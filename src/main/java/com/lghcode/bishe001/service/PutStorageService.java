package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.PutStorage;
import com.lghcode.bishe001.pojo.vo.PutStorageVo;
import com.lghcode.bishe001.util.PagedResult;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 19:57
 */
public interface PutStorageService {
    void save(PutStorage putStorage);

    PagedResult getList(Integer productNo, Integer pageNum, Integer pageSize);

    List<PutStorageVo> getAll();
}
