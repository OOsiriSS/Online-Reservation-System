package com.example.takeout.service;

import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import com.example.takeout.common.MapPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;


    @Test
    public void findProductByRestaurantTest(){
        JSONResult productByRestaurant = goodsService.findProductByRestaurant(1);

        System.out.println(JSON.toJSON(productByRestaurant));

    }

    @Test
    public void jisuan(){
        MapPoint start = new MapPoint(40.160645,116.306533);

        MapPoint end = new MapPoint(39.975758,116.341814);

        double distence = MapPoint.getDistence(start, end);

        System.out.println("两地距离为" + distence + "km");

    }

}
