package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.grope6.design.entity.Login;
import com.grope6.design.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginContruller {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login2(HttpServletRequest request,
                         @RequestBody JSONObject jsonParam){

        String json = jsonParam.toJSONString();

        String loginName = JSONObject.parseObject(json).getString("loginName");
        String password = JSONObject.parseObject(json).getString("password");
        int role = Integer.parseInt(JSONObject.parseObject(json).getString("role"));

//        System.out.println("json = " + json);
//        System.out.println("loginName = " + loginName);
//        System.out.println("password = " + password);
//        System.out.println("role = " + role);

        Login login = loginService.findByUserId(loginName);

        System.out.println(login.toString());

        if(login != null && login.getUserpassword().equals(password) && login.getNusertype().intValue()==role){

            //添加到session
            HttpSession session = request.getSession();
            session.setAttribute("loginName",loginName);

            if(role == 2){//表示客户（购买者）
                return "success0";
            }else{//表示商家或管理员
                return "success1";
            }
        }
        return "error";
    }
}
