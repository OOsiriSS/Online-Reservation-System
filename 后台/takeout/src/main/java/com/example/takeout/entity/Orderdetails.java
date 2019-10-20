package com.example.takeout.entity;

import java.io.Serializable;

/**
 * orderdetails
 * @author 
 */
public class Orderdetails implements Serializable {
    /**
     * 订单详情主键
     */
    private Integer detailsId;

    /**
     * 订单外键
     */
    private Integer orderId;

    /**
     * 商品外键
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer detailsStock;

    private static final long serialVersionUID = 1L;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getDetailsStock() {
        return detailsStock;
    }

    public void setDetailsStock(Integer detailsStock) {
        this.detailsStock = detailsStock;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Orderdetails other = (Orderdetails) that;
        return (this.getDetailsId() == null ? other.getDetailsId() == null : this.getDetailsId().equals(other.getDetailsId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getDetailsStock() == null ? other.getDetailsStock() == null : this.getDetailsStock().equals(other.getDetailsStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailsId() == null) ? 0 : getDetailsId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getDetailsStock() == null) ? 0 : getDetailsStock().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailsId=").append(detailsId);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", detailsStock=").append(detailsStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}