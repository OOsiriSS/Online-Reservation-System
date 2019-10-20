package com.example.takeout.entity;

import java.io.Serializable;

/**
 * address
 * @author 
 */
public class Address implements Serializable {
    /**
     * 地址主键
     */
    private Integer addressId;

    /**
     * 送餐地址
     */
    private String addressValue;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 送餐电话
     */
    private String addressPhone;

    /**
     * 收货人名字
     */
    private String addressName;

    private static final long serialVersionUID = 1L;



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
        Address other = (Address) that;
        return (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getAddressValue() == null ? other.getAddressValue() == null : this.getAddressValue().equals(other.getAddressValue()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAddressPhone() == null ? other.getAddressPhone() == null : this.getAddressPhone().equals(other.getAddressPhone()))
            && (this.getAddressName() == null ? other.getAddressName() == null : this.getAddressName().equals(other.getAddressName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getAddressValue() == null) ? 0 : getAddressValue().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAddressPhone() == null) ? 0 : getAddressPhone().hashCode());
        result = prime * result + ((getAddressName() == null) ? 0 : getAddressName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", addressValue=").append(addressValue);
        sb.append(", userId=").append(userId);
        sb.append(", addressPhone=").append(addressPhone);
        sb.append(", addressName=").append(addressName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}