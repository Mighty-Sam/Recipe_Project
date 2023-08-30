package com.example.recipt_website_project.controller;

import com.example.recipt_website_project.entity.Result;
import com.example.recipt_website_project.entity.User;
import com.example.recipt_website_project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("會員登入: {}", user);
        User u = (User) userService.login(user);
        return u != null?Result.success():Result.error("用戶名或密碼錯誤!");
    }
}
