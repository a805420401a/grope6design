package com.grope6.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerIndexContruller {
    @RequestMapping("/customer/index")
    public String login(HttpServletRequest request){

        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if(loginName == null){
            return "login";
        }

        return "customer/index";
    }
}
