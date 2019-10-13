package com.lghcode.bishe001.controller;

import com.lghcode.bishe001.pojo.Inventory;
import com.lghcode.bishe001.pojo.OutStorage;
import com.lghcode.bishe001.pojo.Product;
import com.lghcode.bishe001.pojo.PutStorage;
import com.lghcode.bishe001.service.InventoryService;
import com.lghcode.bishe001.service.OutStorageService;
import com.lghcode.bishe001.service.ProductService;
import com.lghcode.bishe001.service.PutStorageService;
import com.lghcode.bishe001.util.PagedResult;
import com.lghcode.bishe001.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 17:46
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PutStorageService putStorageService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OutStorageService outStorageService;

    @RequestMapping("/save")
    public ResultJson save(Product product){
        if (StringUtils.isBlank(product.getProductNo())){
            return ResultJson.error("产品编号不能为空");
        }
        if (StringUtils.isBlank(product.getName())){
            return ResultJson.error("产品名称不能为空");
        }
        if (product.getCustomerId() == null){
            return ResultJson.error("供应商不能为空");
        }
        if (product.getCategoryId() == null){
            return ResultJson.error("分类不能为空");
        }
        if (!productService.checkProductNo(product.getProductNo())){
            return ResultJson.error("产品编号不能重复");
        }
        try {
            product.setStatus(1);
            productService.save(product);
        } catch (Exception e) {
            return ResultJson.error("添加失败，异常异常");
        }
        return ResultJson.success("添加成功");
    }

    @RequestMapping("/delete")
    public ResultJson delete(Integer id){
        if (id == null) {
            return ResultJson.error("产品id不能为空");
        }
        Inventory inventory = inventoryService.findByProductId(id);
        if (inventory != null){
            return ResultJson.error("该产品还存在库位中，请勿删除！");
        }
        try {
            Product product = productService.getProduct(id);
            product.setStatus(0);
            productService.update(product);
        } catch (Exception e) {
            return ResultJson.error("删除失败");
        }
        return ResultJson.success("删除成功");
    }

    @RequestMapping("/getProduct")
    public ResultJson getProduct(Integer id){
        if (id == null) {
            return ResultJson.error("产品id不能为空");
        }
        return ResultJson.success("查找成功",productService.getProduct(id));
    }

    @RequestMapping("/update")
    public ResultJson updateProduct(Product product){
        if (product.getId() == null){
            return ResultJson.error("用户id不能为空");
        }
        if (StringUtils.isBlank(product.getProductNo())){
            return ResultJson.error("产品编号不能为空");
        }
        if (StringUtils.isBlank(product.getName())){
            return ResultJson.error("产品名称不能为空");
        }
        if (product.getCustomerId() == null){
            return ResultJson.error("供应商不能为空");
        }
        if (product.getCategoryId() == null){
            return ResultJson.error("分类不能为空");
        }
        if (!productService.checkProductNo(product.getProductNo(),product.getId())){
            return ResultJson.error("产品编号不能重复");
        }
        try {
            productService.update(product);
        } catch (Exception e) {
            return ResultJson.error("产品更新失败,系统异常");
        }
        return ResultJson.success("产品更新成功");
    }
    @RequestMapping("/queryListPage")
    public ResultJson queryListPage(String productNo,String name,Integer categoryId, Integer customerId,Integer pageNum,Integer pageSize){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedResult pagedResult = productService.getUserList(productNo,name,categoryId,customerId,pageNum,pageSize);
        return ResultJson.success("查询成功",pagedResult);
    }

    @RequestMapping("/putStorage")
    public ResultJson putStorage(Integer putUser,Integer productId,Integer locationId,Integer count){
        if (putUser == null){
            return ResultJson.error("处理人不能为空");
        }
        if (productId == null){
            return ResultJson.error("入库产品不能为空");
        }
        if (locationId == null){
            return ResultJson.error("库位不能为空");
        }
        if (count == null || count <= 0){
            return ResultJson.error("入库数量必须大于零");
        }
        PutStorage putStorage = new PutStorage();
        putStorage.setPutUser(putUser);
        putStorage.setProductId(productId);
        putStorage.setLocationId(locationId);
        putStorage.setPutCount(count);
        putStorage.setPutDate(new Date());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String datestr = dateFormat.format(date);
        putStorage.setPutNo("PutIn"+datestr.substring(0,4)+datestr.substring(5,7)+datestr.substring(8,10)+datestr.substring(11,13)+datestr.substring(14,16)+datestr.substring(17,19));
        try {
            putStorageService.save(putStorage);
        } catch (Exception e) {
            return ResultJson.error("入库失败，系统异常");
        }
        Inventory invent = inventoryService.findByProductId(productId,locationId);
        if (invent == null) {
            Inventory inventory = new Inventory();
            inventory.setProductId(productId);
            inventory.setLocationId(locationId);
            inventory.setCount(count);
            inventory.setLimitWarnCount(100);
            inventoryService.save(inventory);
        }else{
            invent.setCount(invent.getCount()+count);
            inventoryService.update(invent);
        }
        return ResultJson.success("入库成功");
    }

    @RequestMapping("/outStorage")
    public ResultJson outStorage(Integer outUser,Integer productId,Integer locationId,Integer count,String reciveUser,String productionNo,String remark){
        if (outUser == null){
            return ResultJson.error("处理人不能为空");
        }
        if (productId == null){
            return ResultJson.error("出库产品不能为空");
        }
        if (locationId == null){
            return ResultJson.error("库位不能为空");
        }
        if (count == null || count <= 0) {
            return ResultJson.error("出库产品数量不能小于零");
        }
        if (StringUtils.isBlank(reciveUser)){
            return ResultJson.error("接收人不能为空");
        }
        Inventory invent = inventoryService.findByProductId(productId,locationId);
        if (invent.getCount() < count){
            return ResultJson.error("库存不够");
        }
        invent.setCount(invent.getCount()-count);
        inventoryService.update(invent);
        OutStorage outStorage =new OutStorage();
        outStorage.setOutCount(count);
        outStorage.setOutDate(new Date());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String datestr = dateFormat.format(date);
        outStorage.setOutNo("PutOut"+datestr.substring(0,4)+datestr.substring(5,7)+datestr.substring(8,10)+datestr.substring(11,13)+datestr.substring(14,16)+datestr.substring(17,19));
        outStorage.setOutUser(outUser);
        outStorage.setProductId(productId);
        outStorage.setPickUpUser(reciveUser);
        outStorage.setProductionNo(productionNo);
        outStorage.setRemark(remark);
        try {
            outStorageService.save(outStorage);
        } catch (Exception e) {
            return ResultJson.error("出库失败，系统异常");
        }
        return ResultJson.success("出库成功");
    }
}
