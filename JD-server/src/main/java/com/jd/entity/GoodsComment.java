package com.jd.entity;

import lombok.Data;

@Data
public class GoodsComment {
    private Integer goodsCommentId;
    private Integer goodsId;
    private String GoodsCommentMessage;
    private String userPicture;
    private String userName;
}
