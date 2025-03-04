package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.GoodsTitleImages;
import com.jd.mapper.GoodsTitleImagesMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTitleImagesService {

    @Autowired
    private GoodsTitleImagesMapper goodsTitleImagesMapper;
    public Result getARandomTitleImage(){
        Result result;
        try {
            GoodsTitleImages goodsTitleImages = goodsTitleImagesMapper.selectOneTitleImageRandom();
            result = Result.success(goodsTitleImages);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        return result;
    }
}
