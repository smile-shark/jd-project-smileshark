package com.jd.controller;

import com.jd.common.Result;
import com.jd.mapper.GoodsCommentMapper;
import com.jd.request.param.RequestParam;
import com.jd.service.*;
import com.jd.utils.SearchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class JDController {
    @Autowired
    private GoodsTitleImagesService goodsTitleImagesService;
    @Autowired
    private GoodsInfoService goodsInfoService;
    @Autowired
    private GoodsCommentService goodsCommentService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping("/home/data")
    public Result getHomeData(){
        //返回主页的数据
        /*
        * 1. 后台随机返回100条数据到前端*/
        return goodsInfoService.getHomeData();
    }
    @RequestMapping("/home/title/data")
    public Result getHomeTitleData(){
        //随机返回一张图片的和其对应的id数据
        return goodsTitleImagesService.getARandomTitleImage();
    }
    @RequestMapping("/delivery/data")
    public Result getDeliveryDataByGoodsId(@RequestBody RequestParam requestParam){
        int goodsId=requestParam.getGoodsId();
        return goodsInfoService.getDetailsData(goodsId);
    }
    @RequestMapping("/goods/comment")
    public Result getGoodsComment(@RequestBody RequestParam requestParam){
        int goodsId=requestParam.getGoodsId();
        return goodsCommentService.getGoodsCommentByGoodsId(goodsId);
    }
    @RequestMapping("/search/content")
    public Result searchContent(@RequestBody RequestParam requestParam){
        return goodsInfoService.searchGoodsInfo(requestParam);
    }
    @RequestMapping("/login/password")
    public Result loginPassword(@RequestBody RequestParam requestParam){
        return customerService.loginUsePassword(requestParam);
    }
    @RequestMapping("/get/email")
    public Result getEmail(@RequestHeader("User-Token")String token){
        return customerService.getEmail(token);
    }
    @RequestMapping("/get/shopping/cart")
    public Result getShoppingCart(@RequestHeader("User-Token")String token){
        return shoppingCartService.getShoppingCart(token);
    }
    @RequestMapping("/add/goods/to/shopping/cart")
    public Result addGoodsToShoppingCart(
            @RequestHeader("User-Token") String token,
            @RequestBody RequestParam requestParam){
        /*
        * 1. 解析token获取到用户的id
        * 2. 通过用户id和传递上来的商品进行数据的添加
        * 3. 如果发现当前购物车中有当前物品就增加商品的数量*/
        return shoppingCartService.addGoodsToShoppingCart(token,requestParam);
    }
}
