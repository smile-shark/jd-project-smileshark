package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jd.common.MyPage;
import com.jd.common.Result;
import com.jd.entity.GoodsInfo;
import com.jd.mapper.GoodsInfoMapper;
import com.jd.request.param.RequestParam;
import com.jd.utils.SearchUtils;
import com.jd.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsInfoService {

    private SqlSession sqlSession;

    public Result getHomeData(){
        Result result;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            List<GoodsInfo> goodsInfos = mapper.selectHomeData();
            result=Result.success(goodsInfos);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        sqlSession.close();
        return result;
    }
    public Result getDetailsData(int goodsId){
        Result result;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            GoodsInfo goodsInfo = mapper.selectDeliveryData(goodsId);
            result=Result.success(goodsInfo);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        sqlSession.close();
        return result;
    }
    public Result searchGoodsInfo(RequestParam requestParam){
        Result result;
        try {
            sqlSession=SqlSessionUtils.getSqlSession();
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            Page<Object> objects = PageHelper.startPage(requestParam.getPageNum(), 20);
            List<GoodsInfo> goodsInfos = mapper.selectDataLikeSearchContent(
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
        sqlSession.close();
        return result;
    }
}
