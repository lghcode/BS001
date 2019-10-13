package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.CustomerMapper;
import com.lghcode.bishe001.pojo.Customer;
import com.lghcode.bishe001.service.CustomerService;
import com.lghcode.bishe001.util.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 17:05
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void save(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public boolean checkSupplierNo(String supplierNo) {
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("supplierNo",supplierNo);
        Customer customer = customerMapper.selectOneByExample(example);
        return customer == null;
    }

    @Override
    public boolean checkSupplierNo(String supplierNo, Integer id) {
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("supplierNo",supplierNo);
        criteria.andNotEqualTo("id",id);
        Customer customer = customerMapper.selectOneByExample(example);
        return customer == null;
    }

    @Override
    public PagedResult getUserList(String supplierNo, String name, Integer pageNum, Integer pageSize) {
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(supplierNo)){
            criteria.andLike("supplierNo","%"+supplierNo+"%");
        }
        if (StringUtils.isNotBlank(name)){
            criteria.andLike("name","%"+name+"%");
        }
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<Customer> customerList = customerMapper.selectByExample(example);
        PageInfo<Customer> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }

    @Override
    public void delete(Integer id) {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Object getUser(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
