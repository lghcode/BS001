package com.lghcode.bishe001.pojo.vo;

import java.util.Date;

/**
 * @author lghcode@qq.com
 * @date 2019/10/12 15:23
 */
public class OutStorageVo {
    private Integer outId;
    private Date outDate;
    private String outUser;
    private Integer outCount;
    private String reciveUser;
    private String productionNo;
    private String remark;
    private String outNo;
    private String productNo;
    private String productName;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOutUser() {
        return outUser;
    }

    public void setOutUser(String outUser) {
        this.outUser = outUser;
    }

    public Integer getOutCount() {
        return outCount;
    }

    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
    }

    public String getReciveUser() {
        return reciveUser;
    }

    public void setReciveUser(String reciveUser) {
        this.reciveUser = reciveUser;
    }

    public String getProductionNo() {
        return productionNo;
    }

    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOutNo() {
        return outNo;
    }

    public void setOutNo(String outNo) {
        this.outNo = outNo;
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
