package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jd.common.MyPage;
import com.jd.common.Result;
import com.jd.entity.GoodsInfo;
import com.jd.mapper.GoodsInfoMapper;
import com.jd.mapper.GoodsTitleImagesMapper;
import com.jd.request.param.RequestParam;
import com.jd.utils.SearchUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GoodsInfoService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private GoodsTitleImagesMapper goodsTitleImagesMapper;

    public Result getHomeData(){
        Result result;
        try{
            List<GoodsInfo> goodsInfos = goodsInfoMapper.selectHomeData();
            result=Result.success(goodsInfos);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        return result;
    }
    public Result getDetailsData(int goodsId){
        Result result;
        try {
            GoodsInfo goodsInfo = goodsInfoMapper.selectDeliveryData(goodsId);
            result=Result.success(goodsInfo);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        return result;
    }
    public Result searchGoodsInfo(RequestParam requestParam){
        Result result;
        try {
            Page<Object> objects = PageHelper.startPage(requestParam.getPageNum(), 20);
            List<GoodsInfo> goodsInfos = goodsInfoMapper.selectDataLikeSearchContent(
                    SearchUtils.toBroadString(
                            requestParam.getSearchContent()
                    )
            );
            MyPage myPage=new MyPage();
            myPage.setCount((int) objects.getTotal());
            myPage.setPages(objects.getPages());
            myPage.setData(goodsInfos);
            result=Result.success(myPage);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        return result;
    }
}
