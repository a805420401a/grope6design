package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.grope6.design.dto.GoodsAndPicture;
import com.grope6.design.dto.GoodsCartData;
import com.grope6.design.dto.TableDatagrid;
import com.grope6.design.dto.GoodsIndentData;
import com.grope6.design.entity.Cartitem;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.entity.Indentitem;
import com.grope6.design.service.CartItemService;
import com.grope6.design.service.GoodsService;
import com.grope6.design.service.GoodsShowService;
import com.grope6.design.service.IndentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    IndentItemService indentItemService;

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
    public TableDatagrid<GoodsCartData> showGoodsCart(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("customer/cart");
        HttpSession session = request.getSession();
        String buyerid = (String) session.getAttribute("loginName");
        TableDatagrid<GoodsCartData> tableDatagrid = new TableDatagrid<>();

        List<GoodsCartData> goodsCartDataList = new ArrayList<>();
        List<Cartitem> cartitemList = cartItemService.findAllByUserId(buyerid);

        for(Cartitem i : cartitemList){
            Goods goods = goodsService.findByGoodsId(i.getGoodsid());  //获取商品信息
            Goodsshow goodsshow = goodsShowService.findByGoodsid(i.getGoodsid()); //获取商品图片
            GoodsCartData goodsCartData = new GoodsCartData(goods.getGoodsid(),
                                                            i.getCartitemid(),
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

        tableDatagrid.setData(goodsCartDataList);
        tableDatagrid.setCount(goodsCartDataList.size());
        tableDatagrid.setCode(0);
        tableDatagrid.setMsg("购物车数据");

        return tableDatagrid;
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
            goodsCartData.setGoodsid(JSONObject.parseObject(s).getString("goodsid"));
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

        totalPrice = Double.parseDouble(String.format("%.2f", totalPrice));

        model.addAttribute("totalPrice",totalPrice);

        return "customer/place_order";
    }

    @RequestMapping("/customer/showGoodsIndent")
    @ResponseBody
    public TableDatagrid<GoodsCartData> showGoodsIndent(HttpServletRequest request){

        TableDatagrid<GoodsCartData> tableDatagrid = new TableDatagrid<>();

        List<GoodsCartData> goodsCartDataList = (List) request.getSession().getAttribute("goodsCartDataList");

//        System.out.println(goodsCartDataList.size());

//        for(GoodsCartData g : goodsCartDataList){
//            System.out.println(g.toString());
//        }
        tableDatagrid.setData(goodsCartDataList);
        tableDatagrid.setCount(goodsCartDataList.size());
        tableDatagrid.setCode(0);
        tableDatagrid.setMsg("订单数据");

        return tableDatagrid;
    }

    @RequestMapping("/customer/user_center_order")
    public String user_center_order(HttpServletRequest request,Model model){

        HttpSession session = request.getSession();
        //将数据存入数据库中
        List<GoodsCartData> goodsCartDataList = (List) session.getAttribute("goodsCartDataList");

        if(goodsCartDataList == null){  //不是通过提交订单进入订单界面的
            return "customer/user_center_order";
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String stringDate = formatter.format(date);

        String timestamp = String.valueOf(date.getTime()/1000);

//        System.out.println(timestamp);

        for(GoodsCartData g : goodsCartDataList ){
            Goods goods = goodsService.findByGoodsId(g.getGoodsid());
            Indentitem indentitem = new Indentitem( g.getGoodsid()+timestamp,
                                                    (String)session.getAttribute("loginName"),
                                                    goods.getMerchantid(),
                                                    g.getGoodsid(),
                                                    g.getGoodsPrice(),
                                                    g.getGoodsNumber(),
                                                    stringDate,false,false,false
                                                    );
            indentItemService.insertIndentitem(indentitem);
        }
        session.removeAttribute("goodsCartDataList");
        return "customer/user_center_order";
    }

    @RequestMapping("/customer/showGoodsIndent2")
    @ResponseBody
    public TableDatagrid<GoodsIndentData> showGoodsIndent2(HttpServletRequest request){

        TableDatagrid<GoodsIndentData> goodsIndentDataTableDatagrid = new TableDatagrid<>();

        List<GoodsIndentData> goodsIndentDataList = new ArrayList<>();

        List<Indentitem> indentitemList = indentItemService.findAllByBuyerId((String)request.getSession().getAttribute("loginName"));

        for(Indentitem i : indentitemList){
            Goods goods = goodsService.findByGoodsId(i.getGoodsid());
            Goodsshow goodsshow = goodsShowService.findByGoodsid(i.getGoodsid());
            GoodsIndentData goodsIndentData = new GoodsIndentData(
                    i.getIndentitemid(),
                    goodsshow.getPicturepath(),
                    goods.getName(),
                    i.getPrice(),
                    i.getNumber(),
                    i.getPrice()*i.getNumber(),
                    i.getIndentdatetime(),
                    i.isPaystate()?"已支付":"未支付",
                    i.isFinishstate()?"已确认收货":"未确认收货",
                    i.isShippingstatus()?"已发货":"未发货");
            goodsIndentDataList.add(goodsIndentData);
        }
        goodsIndentDataTableDatagrid.setData(goodsIndentDataList);
        goodsIndentDataTableDatagrid.setCount(goodsIndentDataList.size());
        goodsIndentDataTableDatagrid.setCode(0);
        goodsIndentDataTableDatagrid.setMsg("已下订单数据");

        return goodsIndentDataTableDatagrid;
    }

    @RequestMapping("/customer/payAndNotarize")
    @ResponseBody
    public String payAndNotarize(HttpServletRequest request){

        String data = (String)request.getParameter("sign");
        String goodsindentitemid = (String)request.getParameter("goodsindentitemid");

        if(data.equals("1")){
            //支付
            indentItemService.updatePayStateByIndentItemId(goodsindentitemid);
            return "支付成功";
        }else if(data.equals("2")){
            //确认收货
            Indentitem indentitem = indentItemService.findByIndentItemId(goodsindentitemid);
            if(!indentitem.isPaystate()){
                return "确认收货失败，请先支付";
            }
            indentItemService.updateFinishStateByIndentItemId(goodsindentitemid);
            return "确认收货成功";
        }

        return"操作有误";
    }
}
