package com.Takagi.swagger.controller;

import com.Takagi.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //只要我們的接口中，返回值存在實體類，他就會被掃描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制類")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用戶名") String username){
        return "hello "+username;
    }
}
