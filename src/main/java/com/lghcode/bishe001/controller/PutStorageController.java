package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.vo.PutStorageVo;
import com.lghcode.bishe001.service.PutStorageService;
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
@RequestMapping("/putStorage")
public class PutStorageController {

    @Autowired
    private PutStorageService putStorageService;

    @RequestMapping("/findList")
    public ResultJson findList(Integer pageNum,Integer pageSize,Integer productNo){
      if (pageNum == 0) {
          pageNum = 1;
      }
      if (pageSize == 0){
          pageSize = 10;
      }
      PagedResult pagedResult = putStorageService.getList(productNo,pageNum,pageSize);
      return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/excel")
    public void excel(HttpServletResponse response){
        String fileName = "入库统计表";
        List<PutStorageVo> list = putStorageService.getAll();
        String[] excelHeader = {"入库id#putId","入库单号#putNo","入库产品编号#productNo","入库产品名称#productName","入库数量#putCount","入库人#putUser"};
        try {
            ExcelUtils2.export(response,fileName,excelHeader,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
