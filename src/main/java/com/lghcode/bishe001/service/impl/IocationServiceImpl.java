package com.lghcode.bishe001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lghcode.bishe001.mapper.IocationMapper;
import com.lghcode.bishe001.pojo.Iocation;
import com.lghcode.bishe001.service.IocationService;
import com.lghcode.bishe001.util.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 21:36
 */
@Service
public class IocationServiceImpl implements IocationService {

    @Autowired
    private IocationMapper iocationMapper;

    @Override
    public void save(Iocation iocation) {
        iocationMapper.insert(iocation);
    }

    @Override
    public void update(Iocation iocation) {
        iocationMapper.updateByPrimaryKeySelective(iocation);
    }

    @Override
    public PagedResult getUserList(String areaNo, Integer pageNum, Integer pageSize) {
        Example example = new Example(Iocation.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(areaNo)){
            criteria.andLike("areaNo","%"+areaNo+"%");
        }
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<Iocation> customerList = iocationMapper.selectByExample(example);
        PageInfo<Iocation> customerPageInfo = new PageInfo<>(customerList);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPageNum(pageNum);
        pagedResult.setTotalPage(customerPageInfo.getPages());
        pagedResult.setTotalRecord(customerPageInfo.getTotal());
        pagedResult.setRows(customerList);
        return pagedResult;
    }

    @Override
    public void delete(Integer id) {
        iocationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Iocation getIocation(Integer id) {
        return iocationMapper.selectByPrimaryKey(id);
    }
}
