package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Iocation {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 仓库区域编号
     */
    @Column(name = "area_no")
    private String areaNo;

    /**
     * 仓库区域描述
     */
    @Column(name = "area_explain")
    private String areaExplain;

    /**
     * 排号编号
     */
    @Column(name = "row_no")
    private String rowNo;

    /**
     * 排号描述
     */
    @Column(name = "row_explain")
    private String rowExplain;

    /**
     * 座号编号
     */
    @Column(name = "seat_no")
    private String seatNo;

    /**
     * 座号描述
     */
    @Column(name = "seat_explain")
    private String seatExplain;

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
     * 获取仓库区域编号
     *
     * @return area_no - 仓库区域编号
     */
    public String getAreaNo() {
        return areaNo;
    }

    /**
     * 设置仓库区域编号
     *
     * @param areaNo 仓库区域编号
     */
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    /**
     * 获取仓库区域描述
     *
     * @return area_explain - 仓库区域描述
     */
    public String getAreaExplain() {
        return areaExplain;
    }

    /**
     * 设置仓库区域描述
     *
     * @param areaExplain 仓库区域描述
     */
    public void setAreaExplain(String areaExplain) {
        this.areaExplain = areaExplain;
    }

    /**
     * 获取排号编号
     *
     * @return row_no - 排号编号
     */
    public String getRowNo() {
        return rowNo;
    }

    /**
     * 设置排号编号
     *
     * @param rowNo 排号编号
     */
    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    /**
     * 获取排号描述
     *
     * @return row_explain - 排号描述
     */
    public String getRowExplain() {
        return rowExplain;
    }

    /**
     * 设置排号描述
     *
     * @param rowExplain 排号描述
     */
    public void setRowExplain(String rowExplain) {
        this.rowExplain = rowExplain;
    }

    /**
     * 获取座号编号
     *
     * @return seat_no - 座号编号
     */
    public String getSeatNo() {
        return seatNo;
    }

    /**
     * 设置座号编号
     *
     * @param seatNo 座号编号
     */
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    /**
     * 获取座号描述
     *
     * @return seat_explain - 座号描述
     */
    public String getSeatExplain() {
        return seatExplain;
    }

    /**
     * 设置座号描述
     *
     * @param seatExplain 座号描述
     */
    public void setSeatExplain(String seatExplain) {
        this.seatExplain = seatExplain;
    }
}