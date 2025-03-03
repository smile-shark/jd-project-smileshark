package com.jd.entity;

import lombok.Data;

@Data
public class ShoppingCart {
    private Integer goodsId;
    private GoodsInfo goodsInfo;
    private Integer customerId;
    private Integer orderId;// 如果orderId为null那么这个就是还没有创建订单的购物车
    private Shop shop;
    private Integer goodsNum;
}
