package com.jd.entity;

import lombok.Data;

import java.util.List;

@Data
public class GoodsInfo {
    Integer goodsId;
    String goodsInfo;
    String goodsOldPrice;
    String goodsNewPrice;
    Integer goodsTypeId;
    String commentNum;
    Shop shop;
    List<GoodsTitleImages> goodsTitleImages;
    List<GoodsDetailsImages> goodsDetailsImages;
    List<DeliveryServiceType> deliveryServiceType;
}
