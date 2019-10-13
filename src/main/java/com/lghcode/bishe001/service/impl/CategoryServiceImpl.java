package com.lghcode.bishe001.service.impl;

import com.lghcode.bishe001.mapper.CategoryMapper;
import com.lghcode.bishe001.pojo.Category;
import com.lghcode.bishe001.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/22 3:34
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryMapper.selectAll();
        Collections.reverse(categoryList);
        return categoryList;
    }

    @Override
    public boolean checkCategory(String name) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        Category customer = categoryMapper.selectOneByExample(example);
        return customer == null;
    }
}
