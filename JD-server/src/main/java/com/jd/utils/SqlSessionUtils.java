package com.jd.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtils {
    public static SqlSession getSqlSession() {
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
