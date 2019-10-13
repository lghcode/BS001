package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.Customer;
import com.lghcode.bishe001.service.CustomerService;
import com.lghcode.bishe001.util.PagedResult;
import com.lghcode.bishe001.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 16:50
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/save")
    public ResultJson save(Customer customer){
        if (StringUtils.isBlank(customer.getSupplierNo())){
            return ResultJson.error("供应商编号不能为空");
        }
        if (StringUtils.isBlank(customer.getName())){
            return ResultJson.error("供应商名称不能为空");
        }
        if (StringUtils.isBlank(customer.getHeadMan())){
            return ResultJson.error("供应商负责人不能为空");
        }
        if (StringUtils.isBlank(customer.getPhone())){
            return ResultJson.error("供应商电话不能为空");
        }
        if (!customerService.checkSupplierNo(customer.getSupplierNo())){
            return ResultJson.error("供应商编号不能重复");
        }
        try {
            customerService.save(customer);
        } catch (Exception e) {
            return ResultJson.error("添加失败，系统异常");
        }
        return ResultJson.success("添加成功");
    }

    @RequestMapping("/queryListPage")
    public ResultJson queryListPage(String supplierNo,String name,Integer pageNum,Integer pageSize){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedResult pagedResult = customerService.getUserList(supplierNo,name,pageNum,pageSize);
        return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/delete")
    public ResultJson deleteCustomer(Integer id){
        if (id == null) {
            return ResultJson.error("客户id不能为空");
        }
        try {
            customerService.delete(id);
        } catch (Exception e) {
            return ResultJson.error("删除失败");
        }
        return ResultJson.success("删除成功");
    }

    @RequestMapping("/getCustomer")
    public ResultJson getCustomer(Integer id){
        if (id == null) {
            return ResultJson.error("客户id不能为空");
        }
        return ResultJson.success("查找成功",customerService.getUser(id));
    }

    @RequestMapping("/update")
    public ResultJson updateCustomer(Customer customer){
        if (customer.getId() == null){
            return ResultJson.error("用户id不能为空");
        }
        if (StringUtils.isBlank(customer.getSupplierNo())){
            return ResultJson.error("供应商编号不能为空");
        }
        if (StringUtils.isBlank(customer.getName())){
            return ResultJson.error("供应商名称不能为空");
        }
        if (StringUtils.isBlank(customer.getHeadMan())){
            return ResultJson.error("供应商负责人不能为空");
        }
        if (StringUtils.isBlank(customer.getPhone())){
            return ResultJson.error("供应商电话不能为空");
        }
        if (!customerService.checkSupplierNo(customer.getSupplierNo(),customer.getId())){
            return ResultJson.error("供应商编号不能重复");
        }
        try {
            customer.setUpdateTime(new Date());
            customerService.update(customer);
        } catch (Exception e) {
            return ResultJson.error("客户更新失败,系统异常");
        }
        return ResultJson.success("客户更新成功");
    }
}
