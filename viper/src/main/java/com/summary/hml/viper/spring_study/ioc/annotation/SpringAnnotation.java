package com.summary.hml.viper.spring_study.ioc.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-23 12:16
 * @Description : 注解版
 */
@Service
public class SpringAnnotation {

    /**
     * spring 注解生成对象
     *     @Service
     *     @Controller
     *     @Repository
     *     @Component
     *
     */


    public void add() {
        System.out.println("service ....");
    }

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/SpringAnnotation.xml");
        SpringAnnotation springAnnotation = applicationContext.getBean("springAnnotation", SpringAnnotation.class);
        springAnnotation.add();

    }


}
