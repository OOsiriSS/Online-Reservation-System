package com.example.takeout.service;

import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AdderssServer adderssServer;


    @Test
    public void findByUserIdTest(){

        JSONResult jsonResult = adderssServer.addressList(2);
        System.out.println(JSON.toJSONString(jsonResult));
    }

    @Test
    public void updateAddressByIdTest(){
        Address address = new Address();
        address.setAddressId(2);
        address.setAddressPhone("21");
        address.setAddressValue("司徒3");

        JSONResult jsonResult = adderssServer.updateAddressById(address);
        System.out.println(jsonResult.toString());
    }

}
