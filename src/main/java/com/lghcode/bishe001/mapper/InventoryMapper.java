package com.lghcode.bishe001.mapper;


import com.lghcode.bishe001.pojo.Inventory;
import com.lghcode.bishe001.pojo.vo.InventoryVo;
import com.lghcode.bishe001.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface InventoryMapper extends MyMapper<Inventory> {
    List<Map<String, Object>> findListPage(Map<String, Object> params);
    List<InventoryVo> getAll();
}