package com.example.takeout.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * preferential
 * @author 
 */
public class Preferential implements Serializable {
    /**
     * 优惠表的主键
     */
    private Integer preferentialId;

    /**
     * 优惠描述信息
     */
    private String preferentialDescribe;

    /**
     * 商品表的外键
     */
    private Integer goodsId;

    /**
     * 比率
     */
    private Float ratio;

    /**
     * 活动的创建时间
     */
    private Date overdue;

    /**
     * 活动的有效状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(Integer preferentialId) {
        this.preferentialId = preferentialId;
    }

    public String getPreferentialDescribe() {
        return preferentialDescribe;
    }

    public void setPreferentialDescribe(String preferentialDescribe) {
        this.preferentialDescribe = preferentialDescribe;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }


    public Date getOverdue() {
        return overdue;
    }

    public void setOverdue(Date overdue) {
        this.overdue = overdue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferential that = (Preferential) o;
        return preferentialId.equals(that.preferentialId) &&
                preferentialDescribe.equals(that.preferentialDescribe) &&
                goodsId.equals(that.goodsId) &&
                ratio.equals(that.ratio) &&
                overdue.equals(that.overdue) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferentialId, preferentialDescribe, goodsId, ratio, overdue, status);
    }

    @Override
    public String toString() {
        return "Preferential{" +
                "preferentialId=" + preferentialId +
                ", preferentialDescribe='" + preferentialDescribe + '\'' +
                ", goodsId=" + goodsId +
                ", ratio=" + ratio +
                ", overdue=" + overdue +
                ", status=" + status +
                '}';
    }
}