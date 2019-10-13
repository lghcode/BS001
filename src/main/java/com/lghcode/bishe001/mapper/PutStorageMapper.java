package com.lghcode.bishe001.mapper;


import com.lghcode.bishe001.pojo.PutStorage;
import com.lghcode.bishe001.pojo.vo.PutStorageVo;
import com.lghcode.bishe001.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface PutStorageMapper extends MyMapper<PutStorage> {
    List<Map<String, Object>> findListPage(Map<String, Object> params);
    List<PutStorageVo> getAll();
}