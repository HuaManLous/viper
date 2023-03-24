package com.summary.hml.viper.spring_study.aop.aopanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-24 22:37
 * @Description : TODO
 */
@Component
public class User {

    public void add() {
        // int a = 10 / 0;
        System.out.println("add .....");
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/AopAnno.xml");
        User user = applicationContext.getBean("user", User.class);
        user.add();
    }
}
