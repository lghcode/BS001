package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.Inventory;
import com.lghcode.bishe001.pojo.vo.InventoryVo;
import com.lghcode.bishe001.util.PagedResult;

import java.util.List;

public interface InventoryService {
    void save(Inventory inventory);

    Inventory findByProductId(Integer productId,Integer locationId);
    Inventory findByProductId(Integer productId);

    void update(Inventory invent);

    PagedResult getUserList(String productName, Integer pageNum, Integer pageSize);

    List<InventoryVo> getAll();
}
