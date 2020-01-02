package com.grope6.design.controller;

import com.github.pagehelper.PageInfo;
import com.grope6.design.dto.GoodsDatagrid;
import com.grope6.design.entity.Goods;
import com.grope6.design.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MerchantIndexContruller {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("index")
    public String login(HttpServletRequest request){

        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if(loginName == null){
            return "login";
        }

        return "index";
    }

    @RequestMapping("/merchant/check_goods")
    public String CheckGoods(HttpServletRequest request){

        return "merchant/check_goods";
    }

    @RequestMapping(path = "merchant", method = RequestMethod.GET)
    public GoodsDatagrid<Goods> goodslist(HttpServletRequest request,
                                          @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                          @RequestParam(value = "limit",defaultValue = "10",required = false) int rows
                                          ){

        GoodsDatagrid<Goods> goodsDatagrid = new GoodsDatagrid<>();

        String merchantid = (String)request.getSession().getAttribute("loginName");

        PageInfo<Goods> courseinfos = goodsService.jwcCourseinfoSelect(merchantid,page,rows);
        goodsDatagrid.setCode(0);
        goodsDatagrid.setCount(courseinfos.getTotal());
        goodsDatagrid.setData(courseinfos.getList());
        goodsDatagrid.setMsg("发布的所有商品");

        return goodsDatagrid;
    }
}
