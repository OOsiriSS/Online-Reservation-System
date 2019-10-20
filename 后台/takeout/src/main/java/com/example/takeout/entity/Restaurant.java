package com.example.takeout.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * restaurant
 * @author 
 */
public class Restaurant implements Serializable {
    private Integer restaurantId;

    /**
     * 餐厅编号
     */
    private String restaurantUser;

    /**
     * 餐厅密码
     */
    private String restaurantPass;

    /**
     * 餐厅地点
     */
    private String restaurantAddress;

    /**
     * 餐厅类型
     */
    private String restaurantType;

    /**
     * 帐号状态
     */
    private Integer restaurantStatus;

    /**
     * 商家名字
     */
    private String restaurantName;

    /**
     * 商家的余额
     */
    private BigDecimal restaurantBalance;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantUser() {
        return restaurantUser;
    }

    public void setRestaurantUser(String restaurantUser) {
        this.restaurantUser = restaurantUser;
    }

    public String getRestaurantPass() {
        return restaurantPass;
    }

    public void setRestaurantPass(String restaurantPass) {
        this.restaurantPass = restaurantPass;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public Integer getRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(Integer restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }

    public BigDecimal getRestaurantBalance() {
        return restaurantBalance;
    }

    public void setRestaurantBalance(BigDecimal restaurantBalance) {
        this.restaurantBalance = restaurantBalance;
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
        Restaurant other = (Restaurant) that;
        return (this.getRestaurantId() == null ? other.getRestaurantId() == null : this.getRestaurantId().equals(other.getRestaurantId()))
            && (this.getRestaurantUser() == null ? other.getRestaurantUser() == null : this.getRestaurantUser().equals(other.getRestaurantUser()))
            && (this.getRestaurantPass() == null ? other.getRestaurantPass() == null : this.getRestaurantPass().equals(other.getRestaurantPass()))
            && (this.getRestaurantAddress() == null ? other.getRestaurantAddress() == null : this.getRestaurantAddress().equals(other.getRestaurantAddress()))
            && (this.getRestaurantType() == null ? other.getRestaurantType() == null : this.getRestaurantType().equals(other.getRestaurantType()))
            && (this.getRestaurantStatus() == null ? other.getRestaurantStatus() == null : this.getRestaurantStatus().equals(other.getRestaurantStatus())
            && (this.getRestaurantName() == null ? other.getRestaurantName() == null : this.getRestaurantName().equals(other.getRestaurantName())))
            && (this.getRestaurantBalance() == null ? other.getRestaurantBalance() == null : this.getRestaurantBalance().equals(other.getRestaurantBalance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRestaurantId() == null) ? 0 : getRestaurantId().hashCode());
        result = prime * result + ((getRestaurantUser() == null) ? 0 : getRestaurantUser().hashCode());
        result = prime * result + ((getRestaurantPass() == null) ? 0 : getRestaurantPass().hashCode());
        result = prime * result + ((getRestaurantAddress() == null) ? 0 : getRestaurantAddress().hashCode());
        result = prime * result + ((getRestaurantType() == null) ? 0 : getRestaurantType().hashCode());
        result = prime * result + ((getRestaurantStatus() == null) ? 0 : getRestaurantStatus().hashCode());
        result = prime * result + ((getRestaurantName() == null) ? 0 : getRestaurantName().hashCode());
        result = prime * result + ((getRestaurantBalance() == null) ? 0 : getRestaurantBalance().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", restaurantId=").append(restaurantId);
        sb.append(", restaurantUser=").append(restaurantUser);
        sb.append(", restaurantPass=").append(restaurantPass);
        sb.append(", restaurantAddress=").append(restaurantAddress);
        sb.append(", restaurantType=").append(restaurantType);
        sb.append(", restaurantStatus=").append(restaurantStatus);
        sb.append(", restaurantName=").append(restaurantName);
        sb.append(", restaurantBalance=").append(restaurantBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);

        sb.append("]");
        return sb.toString();
    }
}