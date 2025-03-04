package com.jd.mapper;

import com.jd.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShopMapper {
    Shop selectByShopId(@Param("shopId") int shopId);
}
