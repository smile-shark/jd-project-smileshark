package com.jd;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jd.common.Result;
import com.jd.entity.Customer;
import com.jd.entity.GoodsInfo;
import com.jd.entity.GoodsTitleImages;
import com.jd.mapper.GoodsInfoMapper;
import com.jd.request.param.RequestParam;
import com.jd.service.SendEmailService;
import com.jd.utils.SqlSessionUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.*;

import static com.jd.utils.JwtUtils.createJWTTokenFromCustomer;
import static com.jd.utils.JwtUtils.parseJWTTokenToCustomer;

@SpringBootTest
class JdServerApplicationTests {


}
