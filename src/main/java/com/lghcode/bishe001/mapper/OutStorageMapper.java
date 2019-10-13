package com.lghcode.bishe001.mapper;


import com.lghcode.bishe001.pojo.OutStorage;
import com.lghcode.bishe001.pojo.vo.OutStorageVo;
import com.lghcode.bishe001.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface OutStorageMapper extends MyMapper<OutStorage> {
    List<Map<String, Object>> findListPage(Map<String, Object> params);
    List<OutStorageVo> getAll();
}