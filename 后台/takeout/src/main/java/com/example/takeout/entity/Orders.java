package com.example.takeout.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * order
 * @author 
 */
public class Orders implements Serializable {
    /**
     * 订单的主健
     */
    private Integer orderId;

    /**
     * 用户的外键
     */
    private Integer userId;

    /**
     * 下订单的时间
     */
    private Timestamp createtime;

    /**
     * 商家的外键
     */
    private Integer restaurantId;

    /**
     * 描述信息
     */
    private String orderDescribe;

    /**
     * 订单总金额
     */
    private BigDecimal orderTotal;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    private Integer addressId;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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
        Orders other = (Orders) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getRestaurantId() == null ? other.getRestaurantId() == null : this.getRestaurantId().equals(other.getRestaurantId()))
            && (this.getOrderDescribe() == null ? other.getOrderDescribe() == null : this.getOrderDescribe().equals(other.getOrderDescribe()))
            && (this.getOrderTotal() == null ? other.getOrderTotal() == null : this.getOrderTotal().equals(other.getOrderTotal()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))   ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getRestaurantId() == null) ? 0 : getRestaurantId().hashCode());
        result = prime * result + ((getOrderDescribe() == null) ? 0 : getOrderDescribe().hashCode());
        result = prime * result + ((getOrderTotal() == null) ? 0 : getOrderTotal().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", createtime=").append(createtime);
        sb.append(", restaurantId=").append(restaurantId);
        sb.append(", orderDescribe=").append(orderDescribe);
        sb.append(", orderTotal=").append(orderTotal);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", addressId=").append(addressId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}