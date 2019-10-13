package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.Iocation;
import com.lghcode.bishe001.service.IocationService;
import com.lghcode.bishe001.util.PagedResult;
import com.lghcode.bishe001.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 21:34
 */
@RestController
@RequestMapping("/iocation")
public class IocationController {

    @Autowired
    private IocationService iocationService;

    @RequestMapping("/save")
    public ResultJson save(Iocation iocation){
        if (StringUtils.isBlank(iocation.getAreaNo())){
            return ResultJson.error("区域编号不能为空");
        }
        try {
            iocation.setStatus(1);
            iocationService.save(iocation);
        } catch (Exception e) {
            return ResultJson.error("添加失败，系统异常");
        }
        return ResultJson.success("添加成功");
    }

    @RequestMapping("/queryListPage")
    public ResultJson queryListPage(String areaNo,Integer pageNum,Integer pageSize){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedResult pagedResult = iocationService.getUserList(areaNo,pageNum,pageSize);
        return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/delete")
    public ResultJson deleteCustomer(Integer id){
        if (id == null) {
            return ResultJson.error("客户id不能为空");
        }
        try {
            iocationService.delete(id);
        } catch (Exception e) {
            return ResultJson.error("删除失败");
        }
        return ResultJson.success("删除成功");
    }

    @RequestMapping("/getIocation")
    public ResultJson getIocation(Integer id){
        if (id == null) {
            return ResultJson.error("id不能为空");
        }
        return ResultJson.success("查找成功",iocationService.getIocation(id));
    }

    @RequestMapping("/update")
    public ResultJson update(Iocation iocation){
        if (iocation.getId() == null){
            return ResultJson.error("id不能为空");
        }
        try {
            iocationService.update(iocation);
        } catch (Exception e) {
            return ResultJson.error("客户更新失败,系统异常");
        }
        return ResultJson.success("客户更新成功");
    }
}
