package com.jd.mapper;

import com.jd.entity.GoodsComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsCommentMapper {
    List<GoodsComment> selectByGoodsId(@Param("goodsId")int goodsId);
}
