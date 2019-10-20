package com.example.takeout.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * goods
 * @author 
 */
public class Goods implements Serializable {
    /**
     * 商品主键
     */
    private Integer goodsId;

    /**
     * 商品类型
     */
    private Integer typeId;

    /**
     * 商品库存
     */
    private Integer goodsStock;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品发布时间
     */
    private Date goodsReleasetime;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品描述
     */
    private String goodsDescribe;

    /**
     * 商家外键
     */
    private Integer restaurantId;

    /**
     * 商品状态
     */
    private Integer goodsStatus;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getGoodsReleasetime() {
        return goodsReleasetime;
    }

    public void setGoodsReleasetime(Date goodsReleasetime) {
        this.goodsReleasetime = goodsReleasetime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(typeId, goods.typeId) &&
                Objects.equals(goodsStock, goods.goodsStock) &&
                Objects.equals(goodsPrice, goods.goodsPrice) &&
                Objects.equals(goodsReleasetime, goods.goodsReleasetime) &&
                Objects.equals(goodsName, goods.goodsName) &&
                Objects.equals(goodsDescribe, goods.goodsDescribe) &&
                Objects.equals(restaurantId, goods.restaurantId) &&
                Objects.equals(goodsStatus, goods.goodsStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, typeId, goodsStock, goodsPrice, goodsReleasetime, goodsName, goodsDescribe, restaurantId, goodsStatus);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", typeId=" + typeId +
                ", goodsStock=" + goodsStock +
                ", goodsPrice=" + goodsPrice +
                ", goodsReleasetime=" + goodsReleasetime +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", restaurantId=" + restaurantId +
                ", goodsStatus=" + goodsStatus +
                '}';
    }
}