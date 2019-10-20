package com.example.takeout.controller;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Goods;
import com.example.takeout.entity.Preferential;
import com.example.takeout.entity.Restaurant;
import com.example.takeout.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("restaurant")
@Api(value = "/restaurant",tags = "restaurantApi",description = "商家接口")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/merchantsRegister")
    @ApiOperation(value = "商家注册",response = Restaurant.class)
    public JSONResult merchantsRegister(@RequestBody Restaurant restaurant){
        return restaurantService.merchantsRegister(restaurant);
    }


    @PostMapping("/updateMerchantsInfo")
    @ApiOperation(value = "修改信息",response = Restaurant.class)
    public JSONResult updateMerchantsInfo(@RequestBody Restaurant restaurant){
        return restaurantService.updateMerchantsInfo(restaurant);
    }


    @PostMapping("/productRelease")
    @ApiOperation(value = "发布商品",response = Goods.class)
    public JSONResult productRelease(@RequestBody Goods product){
        return restaurantService.productRelease(product);
    }


    @GetMapping("/findProduct")
    @ApiOperation(value = "分页查询商品",response = Goods.class)
    public JSONResult findProduct(Integer page){
        return restaurantService.findAllProduct(page);
    }

    @GetMapping("/findAllRestaurant")
    @ApiOperation(value = "查询所有商家")
    public JSONResult findAllRestaurant(Integer page){
        return restaurantService.findAllRestaurant(page);
    }

    @PostMapping("/addPreferential")
    @ApiOperation(value = "添加一条优惠活动")
    public JSONResult addPreferential(@RequestBody Preferential preferential){
        return restaurantService.addPreferential(preferential);
    }

    @GetMapping("/findRestaurantById")
    @ApiOperation(value = "根据id查询商家信息")
    public JSONResult findRestaurantById(Integer id){
        return restaurantService.findRestaurantById(id);
    }


    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    public JSONResult login(String acc,String pass){
        return restaurantService.restaurantLogin(acc,pass);
    }

    @GetMapping("/record")
    @ApiOperation(value = "送餐记录")
    public JSONResult findMealrecordById(Integer restId){
        return restaurantService.findMealrecord(restId);
    }


}
