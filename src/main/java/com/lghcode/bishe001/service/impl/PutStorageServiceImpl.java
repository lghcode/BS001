package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.PutStorageMapper;
import com.lghcode.bishe001.pojo.PutStorage;
import com.lghcode.bishe001.pojo.vo.PutStorageVo;
import com.lghcode.bishe001.service.PutStorageService;
import com.lghcode.bishe001.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 20:13
 */
@Service
public class PutStorageServiceImpl implements PutStorageService {

    @Autowired
    private PutStorageMapper putStorageMapper;
    @Override
    public void save(PutStorage putStorage) {
        putStorageMapper.insert(putStorage);
    }

    @Override
    public PagedResult getList(Integer productNo, Integer pageNum, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("productNo",productNo);
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("putId desc");
        List<Map<String,Object>> customerList = putStorageMapper.findListPage(params);
        PageInfo<Map<String,Object>> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }

    @Override
    public List<PutStorageVo> getAll() {
        return putStorageMapper.getAll();
    }
}
