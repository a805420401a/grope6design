package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.grope6.design.dto.OrderData;
import com.grope6.design.dto.TableDatagrid;
import com.grope6.design.entity.*;
import com.grope6.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MerchantIndexContruller {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsShowService goodsShowService;

    @Autowired
    IndentItemService indentItemService;

    @Autowired
    CustomerService customerService;

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/index")
    public String login(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if(loginName == null){
            return "login";
        }

        Merchant merchant = merchantService.findByUserId(loginName);

        if(merchant == null){
            return "login";
        }

        model.addAttribute("name",merchant.getName());

        return "index";
    }

    @RequestMapping("/merchant/check_goods")
    public String CheckGoods(){

        return "merchant/check_goods";
    }

    @RequestMapping(path = "/merchant", method = RequestMethod.GET)
    @ResponseBody
    public TableDatagrid<Goods> goodslist(HttpServletRequest request,
                                          @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                          @RequestParam(value = "limit",defaultValue = "10",required = false) int rows
                                          ){
        TableDatagrid<Goods> tableDatagrid = new TableDatagrid<>();

        String merchantid = (String)request.getSession().getAttribute("loginName");

        PageInfo<Goods> courseinfos = goodsService.jwcCourseinfoSelect(merchantid,page,rows);

        List<Goods> list = courseinfos.getList();

        tableDatagrid.setCode(0);
        tableDatagrid.setCount(courseinfos.getTotal());
        tableDatagrid.setData(courseinfos.getList());
        tableDatagrid.setMsg("发布的所有商品");

        return tableDatagrid;
    }

    @RequestMapping(path = "/merchant", method = RequestMethod.POST)
    @ResponseBody
    public String deleteGoods(@RequestBody String goodsid){
        String deleteGoodsid = goodsid.substring(goodsid.indexOf("=")+1,goodsid.length());

        if(goodsShowService.deleteByGoodsId(deleteGoodsid) != 1){
            return "error";
        }

        if(goodsService.deleteByGoodsId(deleteGoodsid) != 1){
            return "error";
        }

        return "删除成功";
    }

    @RequestMapping(path = "/merchant/alertGoods/{id}", method = RequestMethod.GET)
    public ModelAndView toAddpage(HttpServletRequest request,@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("merchant/alert_goods");
//        System.out.println("id=" + id);
        if(id != null && !id.equals("")){
            mv.addObject("goodsInfo",goodsService.findByGoodsId(id));
        }
        return mv;
    }


    @RequestMapping("/merchant/add_goods")
    public String addGoods(){

        return "merchant/add_goods";
    }

    @RequestMapping("/merchant/savePicture")
    @ResponseBody
    public HashMap<String,Object> saveGoodsPicture(HttpServletRequest request,@RequestParam(value = "projectImg",required = true) MultipartFile file){

        HashMap<String, Object> map =  new HashMap<String, Object>();

        String originalFilename = file.getOriginalFilename();

        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //图片名称为uuid+图片后缀防止冲突
        String  fileName = UUID.randomUUID().toString()+"."+suffix;

        //文件保存路径
        //String filePath=System.getProperty("user.dir");

        String filePath = null;
        try {
            filePath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        filePath+="static/merchant/upload/";

//        System.out.println("路径："+filePath+fileName);

        FileOutputStream out = null;
        try {
            byte[] fileBytes = file.getBytes();

            File targetFile = new File(filePath);
            //如果目录不存在，创建目录
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            out = new FileOutputStream(filePath+fileName);
            out.write(fileBytes);
            out.flush();
            //写入成功
            request.getSession().setAttribute("goodsPicturePath","/merchant/upload/"+fileName);
            map.put("res",0);
            map.put("path",filePath+fileName);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            //写入失败
            map.put("res",1);
            return map;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/merchant/submitGoodsInfo/{id}" , method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String submitGoodsInfo(HttpServletRequest request,
                                  @RequestBody JSONObject jsonParam,
                                  @PathVariable("id") String id){

        String json = jsonParam.toJSONString();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String goodsid ;
        String goodsname ;
        int goodsnumber ;
        double goodsprice ;
        double goodsdiscount;
        String description ;
        Date manufacturedate ;
        String manufacturer ;
        int durableyears ;

        try {
            goodsid = JSONObject.parseObject(json).getString("goodsid");
            goodsname = JSONObject.parseObject(json).getString("goodsname");
            goodsnumber = Integer.parseInt(JSONObject.parseObject(json).getString("goodsnumber"));
            goodsprice = Double.parseDouble(JSONObject.parseObject(json).getString("goodsprice"));
            goodsdiscount = Double.parseDouble(JSONObject.parseObject(json).getString("goodsdiscount"));
            description = JSONObject.parseObject(json).getString("description");
            manufacturedate = format.parse(JSONObject.parseObject(json).getString("manufacturedate"));
            manufacturer = JSONObject.parseObject(json).getString("manufacturer");
            durableyears = Integer.parseInt(JSONObject.parseObject(json).getString("durableyears"));
        }catch (Exception e) {
            e.printStackTrace();
            return "数据格式错误";
        }

        HttpSession session = request.getSession();
        String goodsPicturePath = (String)session.getAttribute("goodsPicturePath");
        String merchantid = (String)session.getAttribute("loginName");

        //向数据库上传数据

        Goods goods = new Goods(goodsid,merchantid,goodsname,goodsnumber,goodsprice,
                goodsdiscount,description,manufacturedate,manufacturer,durableyears);

        Goodsshow goodsshow = null;
        if(goodsPicturePath != null){
            goodsshow = new Goodsshow(goodsid,goodsPicturePath);
        }

        if(id.equals("0")){
            //添加数据
            Goods goods1 = goodsService.findByGoodsId(goodsid); //查询是否有该id的数据
            if(goods1 != null){
                return "与已有商品的ID重复";
            }

            //如果没有则进行插入处理
            if(goodsService.insertGoods(goods) != 1){
                return "数据上传失败";
            };

            if(goodsShowService.insertGoods(goodsshow) != 1){
                return "图片上传失败";
            }
            session.removeAttribute("goodsPicturePath");
        }else if(id.equals("1")){
            //修改数据
            if(goodsService.updateGoods(goods) != 1){
                return "数据修改失败";
            }

            if(goodsshow != null && goodsShowService.updateGoodsshow(goodsshow) != 1){
                return "图片修改失败";
            }
        }

        return "数据保存成功";
    }

    @RequestMapping("/merchant/process_order")
    public String processOrder(){
        return "/merchant/process_order";
    }

    @RequestMapping(path = "/merchant/orderData", method = RequestMethod.GET)
    @ResponseBody
    public TableDatagrid<OrderData> orderData(HttpServletRequest request){
        TableDatagrid<OrderData> tableDatagrid = new TableDatagrid<>();

        List<OrderData> orderDataList = new ArrayList<>();

        List<Indentitem> indentitemList = indentItemService.findByMerchantId((String)request.getSession().getAttribute("loginName"));

        for(Indentitem i : indentitemList){
            Customer customer = customerService.findByUserId(i.getBuyerid());
            Goods goods = goodsService.findByGoodsId(i.getGoodsid());
            OrderData orderData = new OrderData(
                    i.getIndentitemid(),
                    customer.getName(),
                    customer.getPhone(),
                    customer.getAddress(),
                    i.getGoodsid(),
                    goods.getName(),
                    i.getNumber(),
                    Double.parseDouble(String.format("%.2f", i.getNumber() * i.getPrice())),
                    i.getIndentdatetime(),
                    i.isPaystate()?"已支付":"未支付",
                    i.isShippingstatus()?"已发货":"未发货");
            orderDataList.add(orderData);
        }

        tableDatagrid.setCode(0);
        tableDatagrid.setCount(orderDataList.size());
        tableDatagrid.setData(orderDataList);
        tableDatagrid.setMsg("订单信息");

        return tableDatagrid;
    }


    @RequestMapping("/merchant/confirmDelivery")
    @ResponseBody
    public String confirmDelivery(HttpServletRequest request){

        String orderId = request.getParameter("orderId");

//        System.out.println(orderId);

        indentItemService.updateShippingStatusByIndentItemId(orderId);

        return "success";
    }

    @RequestMapping("/merchant/merchant_Info")
    public String merchant_Info(HttpServletRequest request,  Model model){

        String loginName = (String)request.getSession().getAttribute("loginName");
        Merchant merchant = merchantService.findByUserId(loginName);

        model.addAttribute("id",merchant.getMerchantid());
        model.addAttribute("name",merchant.getName());
        model.addAttribute("address",merchant.getAddress());
        model.addAttribute("reputation",merchant.getReputation());
        model.addAttribute("people",merchant.getLegalperson());
        model.addAttribute("totalAsset",merchant.getTotalassets());

        return "/merchant/merchant_Info";
    }

    @RequestMapping(value = "/merchant/alertMerchantInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String alertMerchantInfo(HttpServletRequest request,  @RequestBody JSONObject jsonParam){

        String json = jsonParam.toJSONString();

        String id = JSONObject.parseObject(json).getString("id");
        String name = JSONObject.parseObject(json).getString("name");
        String address = JSONObject.parseObject(json).getString("address");
        double reputation = Double.parseDouble(JSONObject.parseObject(json).getString("reputation"));
        String people = JSONObject.parseObject(json).getString("people");
        double totalAsset = Double.parseDouble(JSONObject.parseObject(json).getString("totalAsset"));

        Merchant merchant = new Merchant(id,name,address,reputation,people,totalAsset);

//        System.out.println(id+"\n"+name+"\n"+address+"\n"+reputation+"\n"+people+"\n"+totalAsset);

        merchantService.updateMerchant(merchant);

        return "信息修改成功";
    }
}
