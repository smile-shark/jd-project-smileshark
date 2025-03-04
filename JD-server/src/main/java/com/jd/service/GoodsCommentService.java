package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.GoodsComment;
import com.jd.mapper.GoodsCommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsCommentService {
    @Autowired
    private GoodsCommentMapper goodsCommentMapper;

    public Result getGoodsCommentByGoodsId(int goodsId){
        Result result;
        try {
            List<GoodsComment> goodsComments = goodsCommentMapper.selectByGoodsId(goodsId);
            result=Result.success(goodsComments);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        return result;
    }
}
