package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.User;
import com.lghcode.bishe001.pojo.UserMenu;
import com.lghcode.bishe001.service.UserMenuService;
import com.lghcode.bishe001.service.UserService;
import com.lghcode.bishe001.util.FastDFSClient;
import com.lghcode.bishe001.util.MD5Utils;
import com.lghcode.bishe001.util.PagedResult;
import com.lghcode.bishe001.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 14:30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMenuService userMenuService;

    @Autowired
    private FastDFSClient fastDFSClient;
    /**
     * 上传图片
     * @return
     */
    @RequestMapping("/uploadImg")
    public ResultJson uploadImg(MultipartFile imageFile){
        String imgPriex = "http://lghcode.cn:8888/group1/";
        String imgUrl;
        try {
            imgUrl = fastDFSClient.uploadFile(imageFile);
        } catch (IOException e) {
            return ResultJson.error("上传失败，IO异常");
        }
        String imgPath = imgPriex+imgUrl;
        return ResultJson.success("上传成功",imgPath);
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public ResultJson saveUser(User user){
        if (user.getUserType() == null){
            return ResultJson.error("用户类型不能为空");
        }
        if (StringUtils.isBlank(user.getUserNo())){
            return ResultJson.error("用户名或员工编号不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())){
            return ResultJson.error("密码不能为空");
        }
        if (user.getIsLogin() == null){
            return ResultJson.error("用户登录权限必须赋予");
        }
        boolean isNotExit = userService.checkUserIsExit(user.getUserNo());
        if (!isNotExit){
            return ResultJson.error("该用户已经存在");
        }
        try {
            //对密码进行md5加密
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            userService.save(user);
        } catch (Exception e) {
            return ResultJson.error("用户添加失败");
        }
        return ResultJson.success("用户添加成功");
    }

    /**
     * 分页条件查询用户列表
     * @param userNo
     * @param realName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryListPage")
    public ResultJson queryListPage(String userNo,String realName,Integer userType,Integer pageNum,Integer pageSize){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedResult pagedResult = userService.getUserList(userNo,realName,userType,pageNum,pageSize);
        return ResultJson.success("查询成功",pagedResult);
    }

    /**
     * 得到某个用户
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public ResultJson getUser(Integer id){
        if (id == null) {
            return ResultJson.error("用户id不能为空");
        }
        User user = userService.getUser(id);
        if (user == null){
            return ResultJson.error("不存在该用户");
        }
        return ResultJson.success("查找成功",user);
    }

    /**
     * 用户更新
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public ResultJson updateUser(User user){
        if (user.getId() == null){
            return ResultJson.error("用户id不能为空");
        }
        boolean isNotExit = userService.checkUserIsExit(user.getUserNo(),user.getId());
        if (!isNotExit){
            return ResultJson.error("该用户名已经存在");
        }
        try {
            user.setUpdateTime(new Date());
            userService.update(user);
        } catch (Exception e) {
            return ResultJson.error("用户更新失败,系统异常");
        }
        return ResultJson.success("用户更新成功");
    }

    @RequestMapping("/delete")
    public ResultJson deleteUser(Integer id){
        if (id == null) {
            return ResultJson.error("用户id不能为空");
        }
        try {
            userService.delete(id);
        } catch (Exception e) {
           return ResultJson.error("删除失败,系统异常");
        }
        return ResultJson.success("删除成功");
    }

    @RequestMapping("/setLoginPermissions")
    public ResultJson setLoginPermissions(Integer id,Integer isLogin){
        if (id == null) {
            return ResultJson.error("用户id不能为空");
        }
        if (isLogin == null) {
            return ResultJson.error("请选择登录权限");
        }
        try {
            userService.setLoginPermissions(id,isLogin);
        } catch (Exception e) {
            return ResultJson.error("操作失败");
        }
        return ResultJson.success("操作成功");
    }

    @RequestMapping("/login")
    public ResultJson userLogin(String username,String password){
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return ResultJson.error("用户名或密码不能为空");
        }
        boolean isUserExit = userService.checkUserIsExit(username);
        if (isUserExit){
            return ResultJson.error("该用户不存在，请重新输入用户名");
        }
        User user;
        try {
            user = userService.checkUserLogin(username, MD5Utils.getMD5Str(password));
            if (user == null){
                return ResultJson.error("密码输入错误，请重新输入");
            }
            if (user.getIsLogin() == 0){
                return ResultJson.error("该用户没有登录权限,请联系管理员授权");
            }
        } catch (Exception e) {
            return ResultJson.error("系统异常");
        }
        List<UserMenu> userMenuList = userMenuService.findListByUserId(user.getId());
        List<Integer> menuIds = new ArrayList<>();
        for (UserMenu userMenu: userMenuList){
            menuIds.add(userMenu.getMenuId());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("menus",menuIds);
        return ResultJson.success("登录成功",map);
    }

    @RequestMapping("/authorize")
    public ResultJson authorize(Integer userId,String menuIds){
        if (userId == null){
            return ResultJson.error("用户id不能为空");
        }
        if (menuIds == null || menuIds.equals("")){
            return ResultJson.error("菜单Id不能为空");
        }
        List<UserMenu> userMenuList = userMenuService.findListByUserId(userId);
        if (userMenuList != null){
            for (UserMenu userMenu: userMenuList){
               userMenuService.delete(userMenu.getId());
            }
        }
        String[] menuIdArr = menuIds.split(",");
        for (int i = 0;i < menuIdArr.length;i ++){
            Integer meunId = Integer.parseInt(menuIdArr[i]);
            UserMenu userMenu = new UserMenu();
            userMenu.setUserId(userId);
            userMenu.setMenuId(meunId);
            try {
                userMenuService.save(userMenu);
            } catch (Exception e) {
                return ResultJson.error("授权失败,系统异常");
            }
        }
        return ResultJson.success("授权成功");
    }
}
