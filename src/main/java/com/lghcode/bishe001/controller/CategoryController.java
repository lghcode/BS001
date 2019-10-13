package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.Category;
import com.lghcode.bishe001.service.CategoryService;
import com.lghcode.bishe001.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lghcode@qq.com
 * @date 2019/9/22 3:32
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/save")
    public ResultJson save(Category category){
        if (StringUtils.isBlank(category.getName())){
            return ResultJson.error("分类名称不能为空");
        }
        if(!categoryService.checkCategory(category.getName())){
            return ResultJson.error("该分类名称已存在");
        }
        try {
            categoryService.save(category);
        } catch (Exception e) {
            return ResultJson.error("添加失败，系统异常");
        }
        return ResultJson.success("添加成功");
    }

    @RequestMapping("/delete")
    public ResultJson delete(Integer id){
        if (id == null) {
            return ResultJson.error("id不能为空");
        }
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            return ResultJson.error("删除失败");
        }
        return ResultJson.success("删除成功");
    }

    @RequestMapping("/list")
    public ResultJson list(){
        return ResultJson.success("查询成功",categoryService.findAll());
    }
}
