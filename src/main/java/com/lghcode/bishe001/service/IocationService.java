package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.Iocation;
import com.lghcode.bishe001.util.PagedResult;

public interface IocationService {

    void save(Iocation iocation);

    void update(Iocation iocation);

    PagedResult getUserList(String areaNo, Integer pageNum, Integer pageSize);

    void delete(Integer id);

    Iocation getIocation(Integer id);
}
