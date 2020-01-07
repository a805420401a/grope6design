package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.grope6.design.entity.Customer;
import com.grope6.design.entity.Login;
import com.grope6.design.entity.Merchant;
import com.grope6.design.service.CustomerService;
import com.grope6.design.service.LoginService;
import com.grope6.design.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginContruller {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){

        String loginName = (String) request.getSession().getAttribute("loginName");
        if(loginName != null){
            request.getSession().removeAttribute("loginName");
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
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

//        System.out.println(login.toString());

        if(login != null && login.getUserpassword().equals(password) && login.getUsertype()==role){

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

    @RequestMapping(value = "/register2/{id}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login2(HttpServletRequest request,
                         @RequestBody JSONObject jsonParam,
                         @PathVariable("id") String id){

        String json = jsonParam.toJSONString();

        String userId = JSONObject.parseObject(json).getString("userid");
        String name = JSONObject.parseObject(json).getString("name");
        String password = JSONObject.parseObject(json).getString("password");
        String repassword = JSONObject.parseObject(json).getString("repassword");

        if(!password.equals(repassword)){
            return "两次密码不相同，请重新输入";
        }

        Login login = loginService.findByUserId(userId);
        if(login != null){
            return "用户名已存在";
        }

        if(id.equals("0")){
            //用户

            String phone = JSONObject.parseObject(json).getString("phone");
            String address = JSONObject.parseObject(json).getString("address");

            login = new Login(userId,password,2);
            loginService.insertLogin(login);

            Customer customer = new Customer(userId,name,phone,address);
            customerService.insertCustomer(customer);

        }else if(id.equals("1")){
            //商家

            String person = JSONObject.parseObject(json).getString("person");
            double totalAssets = Double.parseDouble(JSONObject.parseObject(json).getString("totalAssets"));
            String address = JSONObject.parseObject(json).getString("address");

            login = new Login(userId,password,1);
            loginService.insertLogin(login);

            Merchant merchant = new Merchant(userId,name,address,7,person,totalAssets);
            merchantService.insertMerchant(merchant);

        }

        return "注册成功";
    }
}
