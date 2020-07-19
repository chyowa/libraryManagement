package com.example.book.controller;

import com.example.book.pojo.Users;
import com.example.book.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UsersService usersService;


    @GetMapping(value = {"/","/index.html"})
    public String toLogin(ModelMap model){
        return "login";
    }


    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(username == null || username.trim().equals("")){
            map.put("msg","用户名不能为空");
            return  "login";
        }
        if(password == null || password.trim().equals("")){
            map.put("msg","密码不能为空");
            return  "login";
        }
        Users users = this.usersService.dologin(username,password);
        logger.info("login users:"+users);
        if(users != null){
            session.setAttribute("loginUser",users);
            return "redirect:/book/getBooks";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }

    }
}
