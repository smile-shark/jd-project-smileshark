package com.jd.mapper;

import com.jd.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CustomerMapper {
    Customer selectCustomerByCustomerEmail(@Param("email") String email);
}
