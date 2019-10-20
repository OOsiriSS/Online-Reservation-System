package com.example.takeout.service;

import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import com.example.takeout.constant.OrderStatus;
import com.example.takeout.entity.Goods;
import com.example.takeout.entity.Preferential;
import com.example.takeout.entity.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void merchantsRegisterTest(){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantAddress("正中食堂2");
        restaurant.setRestaurantPass("222222");
        restaurant.setRestaurantType("吃的");

        JSONResult jsonResult = restaurantService.merchantsRegister(restaurant);
        System.out.println(jsonResult);
    }


    @Test
    public void updateMerchantsInfoTest(){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setRestaurantAddress("正中食堂2");
        restaurant.setRestaurantPass("123123");
        restaurant.setRestaurantType("吃的");

        JSONResult jsonResult = restaurantService.updateMerchantsInfo(restaurant);
        System.out.println(jsonResult);
    }

    @Test
    public void productReleaseTest(){

        Goods goods = new Goods();
        goods.setGoodsDescribe("描述信息");
        goods.setGoodsName("名字");
        goods.setGoodsPrice(new BigDecimal("10"));
        goods.setGoodsStock(100);
        goods.setRestaurantId(1);
        goods.setTypeId(1);
        goods.setGoodsStatus(0);
        goods.setGoodsReleasetime(new Date());

        JSONResult jsonResult = restaurantService.productRelease(goods);
        System.out.println(jsonResult);

    }

    @Test
    public void findByIntervalTest(){
        Timestamp start = new Timestamp(System.currentTimeMillis() - 1000 * 60 * 60 * 15);
        Timestamp end = new Timestamp(System.currentTimeMillis());

        JSONResult json = restaurantService.findByInterval(1, start, end);

        System.out.println(start);
        System.out.println(end);
        System.out.println("---------"+ JSON.toJSON(json) +"---------");
    }


    @Test
    public void tss(){
        System.out.println(OrderStatus.OUT.value);
        System.out.println(OrderStatus.OVERDUE.value);
        System.out.println(OrderStatus.UNCONFIRMED.value);
    }

    @Test
    public void findAllProductTest(){
        JSONResult allProduct = restaurantService.findAllProduct(1);
        System.out.println(JSON.toJSON(allProduct));
    }

    @Test
    public void addPreferentialTest(){
        Preferential preferential = new Preferential();
        preferential.setGoodsId(2);
        preferential.setOverdue(new Timestamp(System.currentTimeMillis()));
        preferential.setStatus(1);
        preferential.setRatio(0.5F);
        preferential.setPreferentialDescribe("这是描述");

        restaurantService.addPreferential(preferential);
    }




    @Test
    public void findRestaurantByIdTest(){
        JSONResult restaurantById = restaurantService.findRestaurantById(2);
        System.out.println(JSON.toJSON(restaurantById));
    }

}
