package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "put_storage")
public class PutStorage {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 入库单号
     */
    @Column(name = "put_no")
    private String putNo;

    /**
     * 入库日期
     */
    @Column(name = "put_date")
    private Date putDate;

    /**
     * 入库负责人Id
     */
    @Column(name = "put_user")
    private Integer putUser;

    /**
     * 入库产品
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品数量
     */
    @Column(name = "put_count")
    private Integer putCount;

    /**
     * 库位
     */
    @Column(name = "location_id")
    private Integer locationId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取入库单号
     *
     * @return put_no - 入库单号
     */
    public String getPutNo() {
        return putNo;
    }

    /**
     * 设置入库单号
     *
     * @param putNo 入库单号
     */
    public void setPutNo(String putNo) {
        this.putNo = putNo;
    }

    /**
     * 获取入库日期
     *
     * @return put_date - 入库日期
     */
    public Date getPutDate() {
        return putDate;
    }

    /**
     * 设置入库日期
     *
     * @param putDate 入库日期
     */
    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    /**
     * 获取入库负责人Id
     *
     * @return put_user - 入库负责人Id
     */
    public Integer getPutUser() {
        return putUser;
    }

    /**
     * 设置入库负责人Id
     *
     * @param putUser 入库负责人Id
     */
    public void setPutUser(Integer putUser) {
        this.putUser = putUser;
    }

    /**
     * 获取入库产品
     *
     * @return product_id - 入库产品
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置入库产品
     *
     * @param productId 入库产品
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品数量
     *
     * @return put_count - 产品数量
     */
    public Integer getPutCount() {
        return putCount;
    }

    /**
     * 设置产品数量
     *
     * @param putCount 产品数量
     */
    public void setPutCount(Integer putCount) {
        this.putCount = putCount;
    }

    /**
     * 获取库位
     *
     * @return location_id - 库位
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 设置库位
     *
     * @param locationId 库位
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}