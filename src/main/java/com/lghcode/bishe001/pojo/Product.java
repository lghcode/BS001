package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Product {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 产品编号
     */
    @Column(name = "product_no")
    private String productNo;

    /**
     * 产品全称
     */
    private String name;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 供应商id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 产地
     */
    private String address;

    /**
     * 计量单位
     */
    @Column(name = "measuring_unit")
    private String measuringUnit;

    /**
     * 有效期
     */
    @Column(name = "useful_life")
    private String usefulLife;

    /**
     * 型号
     */
    @Column(name = "model_no")
    private String modelNo;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
     * 获取产品编号
     *
     * @return product_no - 产品编号
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * 设置产品编号
     *
     * @param productNo 产品编号
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    /**
     * 获取产品全称
     *
     * @return name - 产品全称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品全称
     *
     * @param name 产品全称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取供应商id
     *
     * @return customer_id - 供应商id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置供应商id
     *
     * @param customerId 供应商id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取产地
     *
     * @return address - 产地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置产地
     *
     * @param address 产地
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取计量单位
     *
     * @return measuring_unit - 计量单位
     */
    public String getMeasuringUnit() {
        return measuringUnit;
    }

    /**
     * 设置计量单位
     *
     * @param measuringUnit 计量单位
     */
    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    /**
     * 获取有效期
     *
     * @return useful_life - 有效期
     */
    public String getUsefulLife() {
        return usefulLife;
    }

    /**
     * 设置有效期
     *
     * @param usefulLife 有效期
     */
    public void setUsefulLife(String usefulLife) {
        this.usefulLife = usefulLife;
    }

    /**
     * 获取型号
     *
     * @return model_no - 型号
     */
    public String getModelNo() {
        return modelNo;
    }

    /**
     * 设置型号
     *
     * @param modelNo 型号
     */
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}