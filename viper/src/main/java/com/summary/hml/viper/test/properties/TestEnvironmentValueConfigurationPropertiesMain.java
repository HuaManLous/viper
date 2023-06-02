package com.summary.hml.viper.test.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
     *      1) 必须在注入spring容器的类中（@controller @service @Repository @Componment使用
     *      2） 不能用于静态
     *      3） 不能用于常量
     *      3） 使用@value配置的类不能通过new对象，只能通过注入的方式
     *  b.使用 @ConfigurationProperties 读取配置文件
     *  c.使用 Environment 读取配置文件
     */
    
    @Value("${spring.environment.name}")
    private String a;
    @Value("${spring.environment.test}")
    private String b;

    @Autowired
    private Environment environment;
    
    @Autowired
    private TestEnvironmentValueConfigurationPropertiesConfiguration testEnvironmentValueConfigurationPropertiesConfiguration;

    @Autowired
    private TestConfigurationPropertiesMethod testConfigurationPropertiesMethod;

    @RequestMapping("use")
    public String get(){
        // 通过configurationProperties注释在类上生效
        String datasourceUrl = testEnvironmentValueConfigurationPropertiesConfiguration.getUrl();
        System.out.println("datasourceUrl = " + datasourceUrl);

        // 通过configurationProperties注释在方法上生效
        TestRedisBean testRedisBean = testConfigurationPropertiesMethod.getRedisBean();
        System.out.println("testRedisBean = " + testRedisBean);

        // 通过environment方式获取
        String environmentPropertyA = environment.getProperty("spring.environment.name");
        String environmentPropertyB = environment.getProperty("spring.environment.test");
        System.out.println("environmentPropertyA = " + environmentPropertyA);
        System.out.println("environmentPropertyB = " + environmentPropertyB);
        return a + b;
    }

}
