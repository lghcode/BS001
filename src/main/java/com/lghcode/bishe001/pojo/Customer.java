package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Customer {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 供应商编号
     */
    @Column(name = "supplier_no")
    private String supplierNo;

    /**
     * 供应商名称
     */
    private String name;

    /**
     * 负责人
     */
    @Column(name = "head_man")
    private String headMan;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮件
     */
    private String email;

    /**
     * 网址
     */
    @Column(name = "home_url")
    private String homeUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取供应商编号
     *
     * @return supplier_no - 供应商编号
     */
    public String getSupplierNo() {
        return supplierNo;
    }

    /**
     * 设置供应商编号
     *
     * @param supplierNo 供应商编号
     */
    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    /**
     * 获取供应商名称
     *
     * @return name - 供应商名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置供应商名称
     *
     * @param name 供应商名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取负责人
     *
     * @return head_man - 负责人
     */
    public String getHeadMan() {
        return headMan;
    }

    /**
     * 设置负责人
     *
     * @param headMan 负责人
     */
    public void setHeadMan(String headMan) {
        this.headMan = headMan;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取邮件
     *
     * @return email - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取网址
     *
     * @return home_url - 网址
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * 设置网址
     *
     * @param homeUrl 网址
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}