package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "out_storage")
public class OutStorage {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 出库单号
     */
    @Column(name = "out_no")
    private String outNo;

    /**
     * 出库日期
     */
    @Column(name = "out_date")
    private Date outDate;

    /**
     * 出库负责人
     */
    @Column(name = "out_user")
    private Integer outUser;

    /**
     * 出库产品
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 出库数量
     */
    @Column(name = "out_count")
    private Integer outCount;

    /**
     * 接收人
     */
    @Column(name = "pick_up_user")
    private String pickUpUser;

    /**
     * 生产项目编号
     */
    @Column(name = "production_no")
    private String productionNo;

    /**
     * 备注
     */
    private String remark;

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
     * 获取出库单号
     *
     * @return out_no - 出库单号
     */
    public String getOutNo() {
        return outNo;
    }

    /**
     * 设置出库单号
     *
     * @param outNo 出库单号
     */
    public void setOutNo(String outNo) {
        this.outNo = outNo;
    }

    /**
     * 获取出库日期
     *
     * @return out_date - 出库日期
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * 设置出库日期
     *
     * @param outDate 出库日期
     */
    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    /**
     * 获取出库负责人
     *
     * @return out_user - 出库负责人
     */
    public Integer getOutUser() {
        return outUser;
    }

    /**
     * 设置出库负责人
     *
     * @param outUser 出库负责人
     */
    public void setOutUser(Integer outUser) {
        this.outUser = outUser;
    }

    /**
     * 获取出库产品
     *
     * @return product_id - 出库产品
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置出库产品
     *
     * @param productId 出库产品
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取出库数量
     *
     * @return out_count - 出库数量
     */
    public Integer getOutCount() {
        return outCount;
    }

    /**
     * 设置出库数量
     *
     * @param outCount 出库数量
     */
    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
    }

    /**
     * 获取接收人
     *
     * @return pick_up_user - 接收人
     */
    public String getPickUpUser() {
        return pickUpUser;
    }

    /**
     * 设置接收人
     *
     * @param pickUpUser 接收人
     */
    public void setPickUpUser(String pickUpUser) {
        this.pickUpUser = pickUpUser;
    }

    /**
     * 获取生产项目编号
     *
     * @return production_no - 生产项目编号
     */
    public String getProductionNo() {
        return productionNo;
    }

    /**
     * 设置生产项目编号
     *
     * @param productionNo 生产项目编号
     */
    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo;
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