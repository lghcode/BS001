package com.lghcode.bishe001.pojo.vo;

/**
 * @author lghcode@qq.com
 * @date 2019/10/12 16:03
 */
public class InventoryVo {
//    "limit_warn_count": 100,
//            "productId": 1,
//            "areaNo": "A13",
//            "count": 2,
//            "iocationId": 3,
//            "id": 15,
//            "productNo": "P001",
//            "productName": "螺丝钉2"
    private Integer limit_warn_count;
    private Integer productId;
    private String areaNo;
    private Integer count;
    private Integer iocationId;
    private Integer id;
    private String productNo;
    private String productName;

    public Integer getLimit_warn_count() {
        return limit_warn_count;
    }

    public void setLimit_warn_count(Integer limit_warn_count) {
        this.limit_warn_count = limit_warn_count;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIocationId() {
        return iocationId;
    }

    public void setIocationId(Integer iocationId) {
        this.iocationId = iocationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
