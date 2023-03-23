package com.summary.hml.viper.spring_study.ioc.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-23 14:26
 * @Description : TODO
 */
@Component
public class TestConfig {

    public void stu() {
        System.out.println("true = " + true);
    }


    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestConfig testConfig = applicationContext.getBean("testConfig", TestConfig.class);
        testConfig.stu();
    }
}
