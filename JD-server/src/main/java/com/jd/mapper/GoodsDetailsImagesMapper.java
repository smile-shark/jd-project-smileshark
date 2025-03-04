package com.jd.mapper;

import com.jd.entity.GoodsDetailsImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsDetailsImagesMapper {
    List<GoodsDetailsImages> selectByGoodsId(@Param("goodsId") int goodsId);
}
