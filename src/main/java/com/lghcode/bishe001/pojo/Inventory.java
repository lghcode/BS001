package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Inventory {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品余量
     */
    private Integer count;

    /**
     * 预警值
     */
    @Column(name = "limit_warn_count")
    private Integer limitWarnCount;

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
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品余量
     *
     * @return count - 产品余量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置产品余量
     *
     * @param count 产品余量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取预警值
     *
     * @return limit_warn_count - 预警值
     */
    public Integer getLimitWarnCount() {
        return limitWarnCount;
    }

    /**
     * 设置预警值
     *
     * @param limitWarnCount 预警值
     */
    public void setLimitWarnCount(Integer limitWarnCount) {
        this.limitWarnCount = limitWarnCount;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}