package com.jd.mapper;

import com.jd.entity.GoodsDetailsImages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDetailsImagesMapper {
    List<GoodsDetailsImages> selectByGoodsId(@Param("goodsId") int goodsId);
}
