package com.jd.mapper;

import com.jd.entity.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    Customer selectCustomerByCustomerEmail(@Param("email") String email);
}
