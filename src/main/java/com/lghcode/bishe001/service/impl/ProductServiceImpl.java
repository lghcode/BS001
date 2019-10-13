package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.ProductMapper;
import com.lghcode.bishe001.pojo.Product;
import com.lghcode.bishe001.service.ProductService;
import com.lghcode.bishe001.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 18:12
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public void save(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void delete(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Product getProduct(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkProductNo(String productNo) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productNo",productNo);
        Product product = productMapper.selectOneByExample(example);
        return product == null;
    }

    @Override
    public boolean checkProductNo(String productNo, Integer id) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productNo",productNo);
        criteria.andNotEqualTo("id",id);
        Product product = productMapper.selectOneByExample(example);
        return product == null;
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public PagedResult getUserList(String productNo, String name, Integer categoryId, Integer customerId, Integer pageNum, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("productNo",productNo);
        params.put("name",name);
        params.put("categoryId",categoryId);
        params.put("customerId",customerId);
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<Map<String,Object>> customerList = productMapper.findListPage(params);
        PageInfo<Map<String,Object>> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }
}
