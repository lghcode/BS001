package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.Customer;
import com.lghcode.bishe001.util.PagedResult;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 16:52
 */
public interface CustomerService {

    void save(Customer customer);
    boolean checkSupplierNo(String supplierNo);
    boolean checkSupplierNo(String supplierNo,Integer id);

    PagedResult getUserList(String supplierNo, String name, Integer pageNum, Integer pageSize);

    void delete(Integer id);

    Object getUser(Integer id);

    void update(Customer customer);
}
