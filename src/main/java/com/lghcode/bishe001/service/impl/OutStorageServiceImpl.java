package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.OutStorageMapper;
import com.lghcode.bishe001.pojo.OutStorage;
import com.lghcode.bishe001.pojo.vo.OutStorageVo;
import com.lghcode.bishe001.service.OutStorageService;
import com.lghcode.bishe001.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 22:35
 */
@Service
public class OutStorageServiceImpl implements OutStorageService {

    @Autowired
    private OutStorageMapper outStorageMapper;

    @Override
    public void save(OutStorage outStorage) {
        outStorageMapper.insert(outStorage);
    }

    @Override
    public PagedResult getList(Integer productNo, Integer pageNum, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("productNo",productNo);
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("outId desc");
        List<Map<String,Object>> customerList = outStorageMapper.findListPage(params);
        PageInfo<Map<String,Object>> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }

    @Override
    public List<OutStorageVo> getAll() {
        return outStorageMapper.getAll();
    }
}
