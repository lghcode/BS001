package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.InventoryMapper;
import com.lghcode.bishe001.pojo.Inventory;
import com.lghcode.bishe001.pojo.vo.InventoryVo;
import com.lghcode.bishe001.service.InventoryService;
import com.lghcode.bishe001.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 20:22
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public void save(Inventory inventory) {
        inventoryMapper.insert(inventory);
    }


    @Override
    public Inventory findByProductId(Integer productId,Integer locationId) {
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("locationId",locationId);
        return inventoryMapper.selectOneByExample(example);
    }

    @Override
    public Inventory findByProductId(Integer productId) {
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        return inventoryMapper.selectOneByExample(example);
    }

    @Override
    public void update(Inventory invent) {
        inventoryMapper.updateByPrimaryKeySelective(invent);
    }

    @Override
    public PagedResult getUserList(String productName, Integer pageNum, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",productName);
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<Map<String,Object>> customerList = inventoryMapper.findListPage(params);
        PageInfo<Map<String,Object>> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }

    @Override
    public List<InventoryVo> getAll() {
        return inventoryMapper.getAll();
    }
}
