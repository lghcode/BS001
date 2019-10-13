package com.lghcode.bishe001.pojo.vo;

import java.util.Date;

/**
 * @author lghcode@qq.com
 * @date 2019/10/12 15:51
 */
public class PutStorageVo {

    private String putNo;
    private String putUser;
    private Integer putCount;
    private String areaNo;
    private Integer putId;
    private Date putDate;
    private String productNo;
    private String productName;

    public String getPutNo() {
        return putNo;
    }

    public void setPutNo(String putNo) {
        this.putNo = putNo;
    }

    public String getPutUser() {
        return putUser;
    }

    public void setPutUser(String putUser) {
        this.putUser = putUser;
    }

    public Integer getPutCount() {
        return putCount;
    }

    public void setPutCount(Integer putCount) {
        this.putCount = putCount;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public Integer getPutId() {
        return putId;
    }

    public void setPutId(Integer putId) {
        this.putId = putId;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
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
