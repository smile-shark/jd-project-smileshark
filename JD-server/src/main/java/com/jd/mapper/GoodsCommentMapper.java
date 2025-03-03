package com.jd.mapper;

import com.jd.entity.GoodsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCommentMapper {
    List<GoodsComment> selectByGoodsId(@Param("goodsId")int goodsId);
}
