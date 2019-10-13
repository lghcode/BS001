package com.lghcode.bishe001.mapper;


import com.lghcode.bishe001.pojo.Product;
import com.lghcode.bishe001.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper extends MyMapper<Product> {
    List<Map<String, Object>> findListPage(Map<String, Object> params);
}