package com.summary.hml.viper.springstudy.aop.aopxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-25 00:42
 * @Description : bookXml
 */
public class BookXml {

    public void add() {
        // int a = 10 / 0;
        System.out.println("bookXml add .....");
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/AopXml.xml");
        BookXml bookXml = applicationContext.getBean("bookXml", BookXml.class);
        bookXml.add();
    }

}
