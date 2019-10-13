package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.Category;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/22 3:32
 */
public interface CategoryService {
    void save(Category category);
    void delete(Integer id);
    List<Category> findAll();

    boolean checkCategory(String name);
}
