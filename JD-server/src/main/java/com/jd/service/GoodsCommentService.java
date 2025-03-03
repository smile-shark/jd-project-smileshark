package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.GoodsComment;
import com.jd.mapper.GoodsCommentMapper;
import com.jd.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsCommentService {

    private SqlSession sqlSession;

    public Result getGoodsCommentByGoodsId(int goodsId){
        Result result;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsCommentMapper mapper = sqlSession.getMapper(GoodsCommentMapper.class);
            List<GoodsComment> goodsComments = mapper.selectByGoodsId(goodsId);
            result=Result.success(goodsComments);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        sqlSession.close();
        return result;
    }
}
