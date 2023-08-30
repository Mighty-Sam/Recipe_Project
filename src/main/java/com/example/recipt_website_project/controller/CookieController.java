package com.example.recipt_website_project.controller;

import com.example.recipt_website_project.entity.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CookieController {

    //設置cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_username", "sam"));
        return Result.success();
    }

    //獲取cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies(); //獲取所有的cookies
        for (Cookie cookie:
             cookies) {
            if (cookie.getName().equals("login_username")){
                System.out.println("login_username: "+ cookie.getValue());
            }
        }
        return Result.success();
    }

}
