package com.jd;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class JdServerApplication {

    public static void main(String[] args) {
        // 注册Bouncy Castle
        Security.addProvider(new BouncyCastleProvider());
        SpringApplication.run(JdServerApplication.class, args);
    }

}
