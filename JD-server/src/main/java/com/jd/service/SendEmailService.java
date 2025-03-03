package com.jd.service;

import com.jd.common.Result;
import com.jd.entity.Customer;
import com.jd.mapper.CustomerMapper;
import com.jd.request.param.RequestParam;
import com.jd.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SendEmailService {

    private SqlSession sqlSession;
    private final JavaMailSender mailSender;

    public SendEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public Result sendEmail(RequestParam requestParam) {
        String email = requestParam.getEmail();
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = mapper.selectCustomerByCustomerEmail(email);
            if (customer != null) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("您的登录验证码");
                Random random = new Random();
                String verificationCode = String.valueOf(random.nextInt(1000, 10000));
                message.setText("您的登录验证码为：\n" + verificationCode);
                mailSender.send(message);
                sqlSession.close();
                return Result.success().setMsg("验证码发送成功");
            } else {
                sqlSession.close();
                return Result.error().setMsg("没有该账户");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            return Result.error().setMsg("获取验证码失败");
        }
    }
}
