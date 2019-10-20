package com.example.takeout.service;

import com.example.takeout.mapper.OrdersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersServiceTest {

    @Autowired
    private OrdersMapper ordersMapper;


    @Test
    public void refundTest(){

    }

}
