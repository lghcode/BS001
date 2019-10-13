package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.vo.OutStorageVo;
import com.lghcode.bishe001.service.OutStorageService;
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
 * @date 2019/9/21 19:07
 */
@RestController
@RequestMapping("/outStorage")
public class OutStorageController {

    @Autowired
    private OutStorageService outStorageService;

    @RequestMapping("/findList")
    public ResultJson findList(Integer pageNum,Integer pageSize,Integer productNo){
      if (pageNum == 0) {
          pageNum = 1;
      }
      if (pageSize == 0){
          pageSize = 10;
      }
      PagedResult pagedResult = outStorageService.getList(productNo,pageNum,pageSize);
      return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/excel")
    public void excel(HttpServletResponse response){
        String fileName = "出库统计表";
        List<OutStorageVo> list = outStorageService.getAll();
        String[] excelHeader = {"出库id#outId","出库单号#outNo","出库产品编号#productNo","出库产品名称#productName","出库数量#outCount","出库人#outUser","接收人#reciveUser","生产项目编号#productionNo"};
        try {
            ExcelUtils2.export(response,fileName,excelHeader,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
