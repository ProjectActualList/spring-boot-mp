package com.xing.mp.controller;

import com.xing.mp.beans.msg.Response;
import com.xing.mp.model.User;
import com.xing.mp.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Response login(String code) {
        log.info("微信code:{}", code);
        Response response = new Response();
        User user = loginService.login(code);
        response.success().setResult(user);
        return response;
    }

    @GetMapping("/findUserById")
    public Response findUserById() {
        Response response = new Response();
        User user = loginService.findUserById(1L);
        response.success().setResult(user);
        return response;
    }

}
