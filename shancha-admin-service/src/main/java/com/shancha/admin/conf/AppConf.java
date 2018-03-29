package com.shancha.admin.conf;

import com.shancha.commons.config.DruidProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by weiq on 2018/03/29.
 *
 * @author weiq
 */
@Configuration
@EnableAutoConfiguration
public class AppConf {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.two")
    public DruidProperties druidProperties() {
        return new DruidProperties();
    }
}
