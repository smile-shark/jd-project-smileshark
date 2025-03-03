package com.jd.entity;

import lombok.Data;

@Data
public class Customer {
    private Integer customerId;
    private String customerEmail;
    private String customerPassword;
    private Integer customerState;
}
