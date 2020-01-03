package com.grope6.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.grope6.design.dto.GoodsDatagrid;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.service.GoodsService;
import com.grope6.design.service.GoodsShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MerchantIndexContruller {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsShowService goodsShowService;

    @RequestMapping("/index")
    public String login(HttpServletRequest request){

        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if(loginName == null){
            return "login";
        }

        return "index";
    }

    @RequestMapping("/merchant/check_goods")
    public String CheckGoods(){

        return "merchant/check_goods";
    }

    @RequestMapping(path = "/merchant", method = RequestMethod.GET)
    @ResponseBody
    public GoodsDatagrid<Goods> goodslist(HttpServletRequest request,
                                          @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                          @RequestParam(value = "limit",defaultValue = "10",required = false) int rows
                                          ){
        GoodsDatagrid<Goods> goodsDatagrid = new GoodsDatagrid<>();

        String merchantid = (String)request.getSession().getAttribute("loginName");

        PageInfo<Goods> courseinfos = goodsService.jwcCourseinfoSelect(merchantid,page,rows);

        List<Goods> list = courseinfos.getList();

        goodsDatagrid.setCode(0);
        goodsDatagrid.setCount(courseinfos.getTotal());
        goodsDatagrid.setData(courseinfos.getList());
        goodsDatagrid.setMsg("发布的所有商品");

        return goodsDatagrid;
    }

    @RequestMapping(path = "/merchant", method = RequestMethod.POST)
    @ResponseBody
    public String deleteGoods(@RequestBody String goodsid){
        String deleteGoodsid = goodsid.substring(goodsid.indexOf("=")+1,goodsid.length());

        if(goodsService.deleteByGoodsId(deleteGoodsid) != 1){
            return "error";
        }

        if(goodsShowService.deleteByGoodsId(deleteGoodsid) != 1){
            return "error";
        }

        return "success";
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
    public String AddGoods(){

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
            request.getSession().setAttribute("goodsPicturePath",filePath+fileName);
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
}
