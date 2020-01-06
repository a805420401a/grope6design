package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.grope6.design.dto.GoodsAndPicture;
import com.grope6.design.dto.GoodsCartData;
import com.grope6.design.dto.GoodsDatagrid;
import com.grope6.design.entity.Cartitem;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.service.CartItemService;
import com.grope6.design.service.GoodsService;
import com.grope6.design.service.GoodsShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    CartItemService cartItemService;

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

//        System.out.println(id);

        return mv;
    }

    @RequestMapping("/customer/addGoodsCartItem")
    @ResponseBody
    public String addGoodsCart(HttpServletRequest request){

        String buyerid = (String)request.getSession().getAttribute("loginName");
        String goodsid = request.getParameter("goodsid");
        int number = Integer.parseInt(request.getParameter("number"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

//        System.out.println(goodsid+" "+number+" "+totalPrice);
        Cartitem cartitem = cartItemService.findByGoodsId(goodsid);
        if(cartitem != null){
            cartItemService.updateCartItemAddNumber(goodsid,number);
            cartItemService.updateCartItemAddTotalPrice(goodsid,totalPrice);
        }else{
            cartitem = new Cartitem(buyerid+goodsid,buyerid,goodsid,number,totalPrice);
            cartItemService.insertCartItem(cartitem);
        }

        return "添加成功";
    }

    @RequestMapping("/customer/goodsCart")
    public String goodsCart(){
        return "customer/cart";
    }

    @RequestMapping("/customer/showGoodsCart")
    @ResponseBody
    public GoodsDatagrid<GoodsCartData> showGoodsCart(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("customer/cart");
        HttpSession session = request.getSession();
        String buyerid = (String) session.getAttribute("loginName");
        GoodsDatagrid<GoodsCartData> goodsDatagrid = new GoodsDatagrid<>();

        List<GoodsCartData> goodsCartDataList = new ArrayList<>();
        List<Cartitem> cartitemList = cartItemService.findAllByUserId(buyerid);

        for(Cartitem i : cartitemList){
            Goods goods = goodsService.findByGoodsId(i.getGoodsid());  //获取商品信息
            Goodsshow goodsshow = goodsShowService.findByGoodsid(i.getGoodsid()); //获取商品图片
            GoodsCartData goodsCartData = new GoodsCartData(i.getCartitemid(),
                                                            goodsshow.getPicturepath(), //录入商品信息
                                                            goods.getName(),
                                                            goods.getPrice(),
                                                            goods.getDiscount(),
                                                            i.getGoodsnumber(),
                                                            Double.parseDouble(String.format("%.2f", i.getTotalprice()))
                                                            );
            goodsCartDataList.add(goodsCartData);
//            System.out.println(goodsCartData.toString());
        }

        goodsDatagrid.setData(goodsCartDataList);
        goodsDatagrid.setCount(goodsCartDataList.size());
        goodsDatagrid.setCode(0);
        goodsDatagrid.setMsg("购物车数据");

        return goodsDatagrid;
    }

    @RequestMapping("/customer/delGoodsCartItem")
    @ResponseBody
    public String delGoodsCartItem(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("customer/cart");

        String goodsCartItemId = (String)request.getParameter("goodsCartItemId");

        System.out.println(goodsCartItemId);

        cartItemService.deleteByGoodsCartItemId(goodsCartItemId);

        return "删除成功";
    }

    @RequestMapping(value = "/customer/saveGoodsInfo")
    @ResponseBody
    public String saveGoodsInfo(HttpServletRequest request){

        String data = request.getParameter("goodsJsondata");

        String [] json = data.split("},");

        for( int i = 0 ; i < json.length - 1 ; i ++ ){
            json[i] += "}";
        }

        List<GoodsCartData> goodsCartDataList = new ArrayList<>();

        //解析json串
        for(String s : json){
            GoodsCartData goodsCartData = new GoodsCartData();
            goodsCartData.setGoodsCartItemId(JSONObject.parseObject(s).getString("goodsCartItemId"));
            goodsCartData.setGoodspicture(JSONObject.parseObject(s).getString("goodspicture"));
            goodsCartData.setGoodsName(JSONObject.parseObject(s).getString("goodsName"));
            goodsCartData.setGoodsPrice(Double.parseDouble(JSONObject.parseObject(s).getString("goodsPrice")));
            goodsCartData.setGoodsDiscount(Double.parseDouble(JSONObject.parseObject(s).getString("goodsDiscount")));
            goodsCartData.setGoodsNumber(Integer.parseInt(JSONObject.parseObject(s).getString("goodsNumber")));
            goodsCartData.setGoodsTotalPrice(Double.parseDouble(JSONObject.parseObject(s).getString("goodsTotalPrice")));
            goodsCartDataList.add(goodsCartData);
//            System.out.println(goodsCartData.toString());
        }

        request.getSession().setAttribute("goodsCartDataList",goodsCartDataList);
        return "success";
    }

    @RequestMapping("/customer/place_order")
    public String place_order(HttpServletRequest request,Model model){

        List<GoodsCartData> goodsCartDataList = (List) request.getSession().getAttribute("goodsCartDataList");

        model.addAttribute("number",goodsCartDataList.size());

        double totalPrice = 0;
        for(GoodsCartData g : goodsCartDataList){
            totalPrice += g.getGoodsTotalPrice();
        }

        model.addAttribute("totalPrice",totalPrice);

        return "customer/place_order";
    }

    @RequestMapping("/customer/showGoodsIndent")
    @ResponseBody
    public GoodsDatagrid<GoodsCartData> showGoodsIndent(HttpServletRequest request){

        GoodsDatagrid<GoodsCartData> goodsDatagrid = new GoodsDatagrid<>();

        List<GoodsCartData> goodsCartDataList = (List) request.getSession().getAttribute("goodsCartDataList");

//        System.out.println(goodsCartDataList.size());

//        for(GoodsCartData g : goodsCartDataList){
//            System.out.println(g.toString());
//        }
        goodsDatagrid.setData(goodsCartDataList);
        goodsDatagrid.setCount(goodsCartDataList.size());
        goodsDatagrid.setCode(0);
        goodsDatagrid.setMsg("购物车数据");

        return goodsDatagrid;
    }
}
