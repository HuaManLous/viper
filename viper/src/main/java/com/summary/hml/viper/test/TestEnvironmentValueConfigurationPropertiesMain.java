package com.summary.hml.viper.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-04 15:52
 * @Description : 测试的类
 */
@RestController
public class TestEnvironmentValueConfigurationPropertiesMain {

    /**
     *  a.使用 @Value 读取配置文件
     *  b.使用 @ConfigurationProperties 读取配置文件
     *  c.使用 Environment 读取配置文件
     */

    @Value("${spring.environment.name}")
    private String a;

    @RequestMapping("use")
    public String get(){
        return a;
    }

}
