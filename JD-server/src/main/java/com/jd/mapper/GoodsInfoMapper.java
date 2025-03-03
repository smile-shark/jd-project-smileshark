package com.jd.mapper;

import com.jd.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsInfoMapper {
    List<GoodsInfo> selectAllGoodsInfo();
    List<GoodsInfo> selectHomeData();
    GoodsInfo selectDeliveryData(@Param("goodsId")int goodsId);
    List<GoodsInfo> selectDataLikeSearchContent(@Param("searchContent") String searchContent);
    GoodsInfo selectGoodsInfoByGoodsId(@Param("goodsId")int goodsId);
}
