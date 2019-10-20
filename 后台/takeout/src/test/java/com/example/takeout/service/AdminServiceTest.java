package com.example.takeout.service;

import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void adminRegisterTest(){
        Admin admin = new Admin();
        admin.setAdminUser("admin");
        admin.setAdminPass("123");

        JSONResult jsonResult = adminService.adminRegister(admin);
        System.out.println(jsonResult.toString());
    }

    @Test
    public void adminLoginTest(){
        adminService.adminLogin("admin","111");
    }

    @Test
    public void notAuditListTest(){
        JSONResult jsonResult = adminService.notAuditList();
        System.out.println(JSON.toJSON(jsonResult));
    }

    @Test
    public void passAuditsTest(){
        adminService.passAudits(1);
    }

    @Test
    public void restaurantStatisticalTest(){
        JSONResult jsonResult = adminService.restaurantStatistical();
        System.out.println(JSON.toJSON(jsonResult));
    }

    @Test
    public void userStatisticalTest(){
        JSONResult jsonResult = adminService.userStatistical();
        System.out.println(JSON.toJSON(jsonResult));
    }

}
