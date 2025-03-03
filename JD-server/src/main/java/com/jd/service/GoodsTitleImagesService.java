package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.GoodsTitleImages;
import com.jd.mapper.GoodsTitleImagesMapper;
import com.jd.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class GoodsTitleImagesService {

    private SqlSession sqlSession;

    public Result getARandomTitleImage(){
        Result result;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsTitleImagesMapper mapper = sqlSession.getMapper(GoodsTitleImagesMapper.class);
            GoodsTitleImages goodsTitleImages = mapper.selectOneTitleImageRandom();
            result = Result.success(goodsTitleImages);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        sqlSession.close();
        return result;
    }
}
