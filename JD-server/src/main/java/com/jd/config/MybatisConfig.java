package com.jd.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import lombok.Data;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Data
@Configuration
@PropertySource("classpath:mybatis-config.properties")
public class MybatisConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource() {{
            setDriverClassName(driverClassName);
            setUrl(url);
        }};
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
    @Bean
    public static MapperScannerConfigurer getMapperScannerConfigurer(){
        return new MapperScannerConfigurer(){{
            setBasePackage("com.jd.mapper");
        }};
    }
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
        return new SqlSessionFactoryBean(){{
           setDataSource(dataSource);
           setTypeAliasesPackage("com.jd.entity");
           setConfiguration(new org.apache.ibatis.session.Configuration(){{
               setMapUnderscoreToCamelCase(true);
               setAutoMappingBehavior(AutoMappingBehavior.FULL);
           }});
           setPlugins(new PageInterceptor());
        }};
    }
}
