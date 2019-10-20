package com.example.takeout.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * paymentdetails
 * @author 
 */
public class Paymentdetails implements Serializable {
    /**
     * 支付详情表
     */
    private Integer paymentDetailsId;

    /**
     * 会员表的外键
     */
    private Integer userId;

    /**
     * 会员本次消费的金额
     */
    private BigDecimal orderMoney;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 订单表的外键
     */
    private Integer orderId;

    private static final long serialVersionUID = 1L;

    public Integer getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Integer paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        Paymentdetails other = (Paymentdetails) that;
        return (this.getPaymentDetailsId() == null ? other.getPaymentDetailsId() == null : this.getPaymentDetailsId().equals(other.getPaymentDetailsId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPaymentDetailsId() == null) ? 0 : getPaymentDetailsId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrderId() == null)? 0 : getOrderId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paymentDetailsId=").append(paymentDetailsId);
        sb.append(", userId=").append(userId);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", status=").append(status);
        sb.append(", orderId=").append(orderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}