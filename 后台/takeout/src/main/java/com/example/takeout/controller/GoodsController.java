package com.example.takeout.controller;

import com.example.takeout.common.JSONResult;
import com.example.takeout.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/goods")
@Api(value = "/goods",tags = "goodsApi", description = "商品接口")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/findProductByRestaurant")
    @ApiOperation(value = "根据商家id查询该商家下的商品")
    public JSONResult findProductByRestaurant(Integer restaurantId){
        return goodsService.findProductByRestaurant(restaurantId);
    }




}
