package com.example.takeout.service;


import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Goods;
import com.example.takeout.entity.Orders;
import com.example.takeout.entity.User;
import com.example.takeout.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void loginTest(){
        JSONResult login = userService.login("396009006@qq.com", "123456");
        System.out.println(JSON.toJSONString(login));
    }


    @Test
    public void updateUserTest(){
        User user = new User();
        user.setUserEmail("260098993@qq.com");
        user.setUserPass("123123");
        user.setUserName("sssa");
        user.setBalance(new BigDecimal("1"));

        userMapper.updateUser(user);
    }

//    @Test
//    public void createOrderTest(){
//
//        ArrayList<Goods> integers = new ArrayList<>();
//        for (int i = 1;i<2;i++){
//            Goods goods = new Goods();
//            goods.setRestaurantId(i);
//            integers.add(goods);
//        }
//        Goods goods = new Goods();
//        goods.setRestaurantId(2);
//        integers.add(goods);
//
//        Map<Integer, Orders> orders = userService.createOrders(integers,2);
//
//        System.out.println("共有："+orders.size()+"条订单");
//
//        System.out.println(JSON.toJSON(orders));
//
//    }

    @Test
    public void saveOrdersTest(){
        ArrayList<Goods> integers = new ArrayList<>();

            Goods goods = new Goods();
            goods.setRestaurantId(1);
            goods.setGoodsId(1);
            integers.add(goods);

            Goods goods2 = new Goods();
            goods2.setGoodsId(1);
            goods2.setRestaurantId(2);
            integers.add(goods);


        userService.saveOrders(integers,2,1);
    }


    @Test
    public void commitOrderTest(){

        User user = new User();
        user.setUserId(2);
        user.setBalance(new BigDecimal(1));

        Orders orders = new Orders();
        orders.setOrderId(4);
        orders.setOrderDescribe("aabbccdd");

        JSONResult jsonResult = userService.commitOrder(12, 2);
        System.out.println(JSON.toJSON(jsonResult));
    }

    @Test
    public void findUserOrderTest(){
        User user = new User();
        user.setUserId(2);
        JSONResult userOrder = userService.findUserOrder(user);

        System.out.println(JSON.toJSON(userOrder));
    }

    @Test
    public void date(){
        Date date = new Date(1552276480L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-sss");
        String format1 = format.format(date);
        System.out.println(format1);

    }

    @Test
    public void reimburseTest(){
        JSONResult reimburse = userService.reimburse(4);
        System.out.println(JSON.toJSON(reimburse));
    }

    @Test
    public void consumptionTest(){
        JSONResult consumption = userService.consumption(2);
        System.out.println(JSON.toJSON(consumption));
    }

    @Test
    public void consumptionInfoTest(){
        JSONResult jsonResult = userService.consumptionInfo(2);
        System.out.println(JSON.toJSON(jsonResult));
    }

    @Test
    public void isDiscount(){
        BigDecimal discount = userService.isDiscount(1);
        System.out.println(discount);
    }

}
