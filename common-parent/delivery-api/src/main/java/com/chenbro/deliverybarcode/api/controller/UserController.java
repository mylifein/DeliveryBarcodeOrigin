package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/13 8:16
 * @Version 1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {


    @RequestMapping("login")
    public User login(String username,String password){
        return null;
    }



}
