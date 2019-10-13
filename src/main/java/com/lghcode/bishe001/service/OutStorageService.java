package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.OutStorage;
import com.lghcode.bishe001.pojo.vo.OutStorageVo;
import com.lghcode.bishe001.util.PagedResult;

import java.util.List;

public interface OutStorageService {
    void save(OutStorage outStorage);

    PagedResult getList(Integer productNo, Integer pageNum, Integer pageSize);

    List<OutStorageVo> getAll();
}
