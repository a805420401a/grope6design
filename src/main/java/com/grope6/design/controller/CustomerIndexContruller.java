package com.grope6.design.controller;

import com.grope6.design.dto.GoodsAndPicture;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.service.GoodsService;
import com.grope6.design.service.GoodsShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CustomerIndexContruller {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsShowService goodsShowService;

    @RequestMapping("/customer/index")
    public String index(HttpServletRequest request){

        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if(loginName == null){
            return "login";
        }

        return "customer/index";
    }

    @RequestMapping("/customer/getData")
    @ResponseBody
    public HashMap<String,Object> getData(HttpServletRequest request, Model model){
        HashMap<String,Object> hashMap = new HashMap<>();

        //查询出所有商品以及该商品的图片路径
        List<GoodsAndPicture> goodsAndPictureList =  goodsService.findAndPictureAll();

        hashMap.put("number",goodsAndPictureList.size());

        for( int i = 1 ; i <= goodsAndPictureList.size() ; i ++){
            hashMap.put("goods"+i, goodsAndPictureList.get(i-1));
        }

        return hashMap;
    }

    @RequestMapping("/customer/goodsParticular/{id}")
    public ModelAndView goodsParticular(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("customer/detail");

        GoodsAndPicture goodsAndPicture = goodsService.findGoodsAndPictureByGoodsId(id);

        mv.addObject("goods",goodsAndPicture);

        System.out.println(id);

        return mv;
    }
}
