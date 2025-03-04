package com.jd.mapper;

import com.jd.entity.DeliveryServiceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DeliveryServiceTypeMapper {
    List<DeliveryServiceType> selectByGoodsId(@Param("goodsId")int goodsId);
}
