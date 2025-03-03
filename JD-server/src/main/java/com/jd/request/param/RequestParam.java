package com.jd.request.param;

import lombok.Data;

@Data
public class RequestParam {
    private Integer goodsId;
    private String searchContent;
    private Integer pageNum;
    private String email;
    private String password;
}
