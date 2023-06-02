package com.summary.hml.viper.test.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-06-02 11:14
 * @Description : configurationProperties
 */
@Component
@PropertySource("classpath:config/application.properties")
@ConfigurationProperties(prefix = "spring.datasource")
public class TestEnvironmentValueConfigurationPropertiesConfiguration {

    private String url;
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
