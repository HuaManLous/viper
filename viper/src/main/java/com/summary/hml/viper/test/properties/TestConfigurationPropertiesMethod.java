package com.summary.hml.viper.test.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-06-02 14:02
 * @Description : TODO
 */
@Configuration
public class TestConfigurationPropertiesMethod {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public TestRedisBean getRedisBean(){
        return new TestRedisBean();
    }

}
