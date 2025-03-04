package com.jd.mapper;

import com.jd.entity.GoodsTitleImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsTitleImagesMapper {
    List<GoodsTitleImages> selectTitleImagesByGoodsId(@Param("goodsId") int goodsId);
    GoodsTitleImages selectOneTitleImageRandom();
}
