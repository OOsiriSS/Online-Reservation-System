package com.example.takeout.controller;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Address;
import com.example.takeout.service.AdderssServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
@ResponseBody
@Api(description = "收货地址接口",tags = "addressAPI",value = "/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AdderssServer adderssServer;


    @GetMapping("/findAddressList")
    @ApiOperation(value = "根据用户查出收货信息")
    public JSONResult findAddressList(Integer user){
        return adderssServer.addressList(user);
    }


    @PostMapping("/updateAddressById")
    @ApiOperation(value = "根据id修改收货信息",response = Address.class)
    public JSONResult updateAddressById(@RequestBody Address address){
        return adderssServer.updateAddressById(address);
    }

    @PostMapping("/addAddress")
    public JSONResult addAddress(@RequestBody Address address){
        return adderssServer.addAddress(address);
    }
}
