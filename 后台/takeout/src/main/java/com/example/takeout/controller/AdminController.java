package com.example.takeout.controller;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Goods;
import com.example.takeout.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@ResponseBody
@Api(description = "管理员接口",value = "/admin",tags = "adminApi")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/findAllNotAudit")
    @ApiOperation(value = "查询所有未审核的商品",response = Goods.class)
    public JSONResult findAllNotAudit(){
        return adminService.notAuditList();
    }


    @GetMapping("pagingNotAudit/{pageNum}")
    @ApiOperation(value = "分页查询未审核的商品",response = Goods.class)
    public JSONResult pagingNotAudit(@PathVariable("pageNum") Integer pageNum){
        return adminService.pageNotAuditList(pageNum);
    }

    @GetMapping("/passAudits/{id}")
    @ApiOperation(value = "通过id修改商品状态")
    public JSONResult passAudits(@PathVariable("id") Integer id){
        return adminService.passAudits(id);
    }

    @GetMapping("/statistical")
    @ApiOperation(value = "餐厅统计(非详情)")
    public JSONResult restaurantStatistical(){
        return adminService.restaurantStatistical();
    }

    @GetMapping("/userStatistical")
    @ApiOperation(value = "会员统计(非详情)")
    public JSONResult userStatistical(){
        return adminService.userStatistical();
    }

    @PostMapping("/login")
    @ApiOperation(value = "管理员登陆")
    public JSONResult login(String account,String password){
        return adminService.adminLogin(account,password);
    }

}
