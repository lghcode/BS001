package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.Product;
import com.lghcode.bishe001.util.PagedResult;

public interface ProductService {
    void save(Product product);

    void delete(Integer id);

    Product getProduct(Integer id);

    boolean checkProductNo(String productNo);
    boolean checkProductNo(String productNo,Integer id);

    void update(Product product);

    PagedResult getUserList(String productNo, String name, Integer categoryId, Integer customerId, Integer pageNum, Integer pageSize);
}
