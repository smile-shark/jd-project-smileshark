package com.jd.controller;

import com.jd.common.Result;
import com.jd.mapper.GoodsCommentMapper;
import com.jd.request.param.RequestParam;
import com.jd.service.*;
import com.jd.utils.SearchUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class JDController {
    @RequestMapping("/home/data")
    public Result getHomeData(){
        //返回主页的数据
        /*
        * 1. 后台随机返回100条数据到前端*/
        return new GoodsInfoService().getHomeData();
    }
    @RequestMapping("/home/title/data")
    public Result getHomeTitleData(){
        //随机返回一张图片的和其对应的id数据
        return new GoodsTitleImagesService().getARandomTitleImage();
    }
    @RequestMapping("/delivery/data")
    public Result getDeliveryDataByGoodsId(@RequestBody RequestParam requestParam){
        int goodsId=requestParam.getGoodsId();
        return new GoodsInfoService().getDetailsData(goodsId);
    }
    @RequestMapping("/goods/comment")
    public Result getGoodsComment(@RequestBody RequestParam requestParam){
        int goodsId=requestParam.getGoodsId();
        return new GoodsCommentService().getGoodsCommentByGoodsId(goodsId);
    }
    @RequestMapping("/search/content")
    public Result searchContent(@RequestBody RequestParam requestParam){
        return new GoodsInfoService().searchGoodsInfo(requestParam);
    }
    @RequestMapping("/login/password")
    public Result loginPassword(@RequestBody RequestParam requestParam){
        return new CustomerService().loginUsePassword(requestParam);
    }
    @RequestMapping("/get/email")
    public Result getEmail(@RequestHeader("User-Token")String token){
        return new CustomerService().getEmail(token);
    }
    @RequestMapping("/get/shopping/cart")
    public Result getShoppingCart(@RequestHeader("User-Token")String token){
        return new ShoppingCartService().getShoppingCart(token);
    }
    @RequestMapping("/send/email")
    public Result sendEmail(@RequestBody RequestParam requestParam){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // 设置邮件服务器的主机名
        mailSender.setHost("smtp.gmail.com");
        // 设置邮件服务器的端口号
        mailSender.setPort(587);
        // 设置发件人的邮箱地址
        mailSender.setUsername("smileshark908@gmail.com");
        // 设置发件人的邮箱密码
        mailSender.setPassword("Qq488089248.");

        // 配置邮件发送的属性
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // 开启调试模式（可选）

        return new SendEmailService(mailSender).sendEmail(requestParam);
    }
    @RequestMapping("/add/goods/to/shopping/cart")
    public Result addGoodsToShoppingCart(
            @RequestHeader("User-Token") String token,
            @RequestBody RequestParam requestParam){
        /*
        * 1. 解析token获取到用户的id
        * 2. 通过用户id和传递上来的商品进行数据的添加
        * 3. 如果发现当前购物车中有当前物品就增加商品的数量*/
        return new ShoppingCartService().addGoodsToShoppingCart(token,requestParam);
    }
}
