package com.example.takeout.controller;

import com.example.takeout.common.JSONResult;
import com.example.takeout.common.MapPoint;
import com.example.takeout.entity.Goods;
import com.example.takeout.entity.User;
import com.example.takeout.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/user")
@CrossOrigin
@Api(value = "/user",tags = "userApi", description = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",response = User.class)
    public JSONResult login(String userEmail, String userPass){
        return userService.login(userEmail,userPass);
    }


    @PostMapping("/register")
    @ApiOperation(value = "用户注册",response = User.class)
    public JSONResult register(@RequestBody User user) throws UnsupportedEncodingException, MessagingException {
        return userService.register(user);
    }


    @GetMapping("/activate")
    @ApiOperation(value = "注册之后验证激活帐号",response = User.class)
    public JSONResult activate(String code) throws UnsupportedEncodingException {
        return userService.activate(code);
    }


    @GetMapping("/cancellation")
    @ApiOperation(value = "账户注销",response = User.class)
    public JSONResult cancellation(String email){
        return userService.cancellation(email);
    }


    @PostMapping("/updataUser")
    @ApiOperation(value = "修改用户的密码和名字")
    public JSONResult updataUser(Integer userId,String userName,String userPass){
        return userService.updateUser(userId,userName,userPass);
    }


//    @PostMapping("/findUserOrder")
//    @ApiOperation(value = "查询该用户下的未支付的有效订单",response = Orders.class)
//    public JSONResult findUserOrder(@RequestBody User user){
//        return userService.findUserOrder(user);
//    }

    @PostMapping("/saveOrders")
    @ApiOperation(value = "生成订单")
    public JSONResult saveOrders(@RequestBody List<Goods> products,Integer userId,Integer addressId){
        return userService.saveOrders(products,userId,addressId);
    }

    @PostMapping("/commitOrder")
    @ApiOperation(value = "提交订单")
    public JSONResult commitOrder(Integer orderId,Integer userId){
        return userService.commitOrder(orderId,userId);
    }

    @PostMapping("/confirmOrder")
    @ApiOperation(value = "确认收货")
    public JSONResult confirmOrder(Integer ordersId){
        return userService.confirmOrder(ordersId);
    }

    @GetMapping("/refund/{id}")
    @ApiOperation(value = "退订")
    public JSONResult refund(@PathVariable("id") Integer orderID){
        return userService.refund(orderID);
    }


    @GetMapping("/consumption")
    @ApiOperation(value = "查看个人的消费金额")
    public JSONResult consumption(Integer userId){
        return userService.consumption(userId);
    }

    @GetMapping("/consumptionInfo")
    @ApiOperation(value = "查看历史订单")
    public JSONResult consumptionInfo(Integer userId){
        return userService.consumptionInfo(userId);
    }

//    @GetMapping("/findRefund/{userId}")
//    @ApiOperation(value = "查看退订的订单")
//    public JSONResult findRefund(@PathVariable("userId") Integer userId){
//        return userService.findRefund(userId);
//    }


    @PostMapping("/distance")
    @ApiOperation(value = "根据两个地点的经纬度计算直线距离")
    public JSONResult distance(@RequestBody List<MapPoint> startAndEnd){
        double distence = MapPoint.getDistence(startAndEnd.get(0), startAndEnd.get(1));
        return JSONResult.ok(distence);
    }
}
