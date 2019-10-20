package com.example.takeout.controller;

import com.example.takeout.entity.User;
import com.example.takeout.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserService userService;

    @Test
    public void registerTest() throws UnsupportedEncodingException, MessagingException {
        User user = new User();
        user.setUserEmail("260098993@qq.com");
        user.setUserName("yst");
        user.setUserPass("123");
        userService.register(user);
    }

    @Test
    public void activateTest() throws UnsupportedEncodingException {
        userService.activate("MjYwMDk4OTkzQHFxLmNvbQ==");
    }


    @Test
    public void cancellationTest(){
        userService.cancellation("260098993@qq.com");
    }

}
