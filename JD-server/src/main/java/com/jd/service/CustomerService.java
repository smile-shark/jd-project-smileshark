package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.Customer;
import com.jd.mapper.CustomerMapper;
import com.jd.request.param.RequestParam;
import com.jd.utils.AESUtils;
import com.jd.utils.JwtUtils;
import com.jd.utils.SqlSessionUtils;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private SqlSession sqlSession;

    public Result loginUsePassword(RequestParam requestParam){
        Result result;
        String email=requestParam.getEmail();
        //首先根据邮箱查找到账号
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = mapper.selectCustomerByCustomerEmail(email);
            if(customer==null){
                sqlSession.close();
                return Result.error().setMsg("没有该账号");
            }
            String password= AESUtils.decrypt(requestParam.getPassword(),customer.getCustomerEmail());
            if(!password.equals(customer.getCustomerPassword())){
                sqlSession.close();
                return Result.error().setMsg("密码错误");
            }
            //创建jwt令牌
            String jwtTokenFromCustomer = JwtUtils.createJWTTokenFromCustomer(customer);
            System.out.println(jwtTokenFromCustomer);
            result = Result.success().setMsg("登录成功").setData(jwtTokenFromCustomer);
        }catch (Exception e){
            e.printStackTrace();
            result=Result.error();
        }
        sqlSession.close();
        return result;
    }
    public Result getEmail(String token){
        Claims claims = JwtUtils.parseJWTTokenToCustomer(token);
        String email = claims.get("customerEmail", String.class);
        return Result.success().setData(email);
    }
}
