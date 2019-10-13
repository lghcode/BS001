package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.vo.InventoryVo;
import com.lghcode.bishe001.service.InventoryService;
import com.lghcode.bishe001.util.ExcelUtils2;
import com.lghcode.bishe001.util.PagedResult;
import com.lghcode.bishe001.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 22:47
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/queryListPage")
    public ResultJson queryListPage(String productName,Integer pageNum, Integer pageSize){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedResult pagedResult = inventoryService.getUserList(productName,pageNum,pageSize);
        return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/excel")
    public void excel(HttpServletResponse response){
        String fileName = "库存统计表";
        List<InventoryVo> list = inventoryService.getAll();
        String[] excelHeader = {"库存号#id","产品编号#productNo","产品名称#productName","数量#count","预警值#limit_warn_count","库位号#iocationId"};
        try {
            ExcelUtils2.export(response,fileName,excelHeader,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
