package com.shancha.report.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by weiq on 2018/03/29.
 *
 * @author weiq
 */
@Configuration
@MapperScan(basePackages = "com.shancha.report.dao")
public class AppConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource datasource() {
        return DruidDataSourceBuilder.create().build();
    }
}
