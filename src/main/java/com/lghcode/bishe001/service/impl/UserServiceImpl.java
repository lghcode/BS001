package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.UserMapper;
import com.lghcode.bishe001.pojo.User;
import com.lghcode.bishe001.service.UserService;
import com.lghcode.bishe001.util.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 15:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public PagedResult getUserList(String userNo, String realName, Integer userType, Integer pageNum, Integer pageSize) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userNo)){
            criteria.andLike("userNo","%"+userNo+"%");
        }
        if (StringUtils.isNotBlank(realName)){
            criteria.andLike("realName","%"+realName+"%");
        }
        if (userType != null){
            criteria.andEqualTo("userType",userType);
        }
        System.out.println("aaa");
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(userPageInfo.getPages());
        pagedResult.setTotalRecord(userPageInfo.getTotal());
        pagedResult.setRows(userList);
        return pagedResult;
    }

    @Override
    public void update(User user) {
       userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setLoginPermissions(Integer id, Integer isLogin) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setIsLogin(isLogin);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public boolean checkUserIsExit(String userNo,Integer id) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userNo",userNo);
        criteria.andNotEqualTo("id",id);
        User user = userMapper.selectOneByExample(example);
        return user == null;
    }

    @Override
    public boolean checkUserIsExit(String userNo) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userNo",userNo);
        User user = userMapper.selectOneByExample(example);
        return user == null;
    }

    @Override
    public User checkUserLogin(String userNo, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userNo",userNo);
        criteria.andEqualTo("password",password);
        return userMapper.selectOneByExample(example);

    }


}
