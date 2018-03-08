package com.shancha.task.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by weiq on 2018/03/08.
 *
 * @author weiq
 */
@Configuration
@MapperScan(basePackages = "com.shancha.task.dao")
public class ApplicationConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource druidDataSource() {
        return DataSourceBuilder.create().build();
    }
}
