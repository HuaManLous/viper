package com.summary.hml.viper.spring_study.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 00:56
 * @Description : spring ioc 测试类
 */
public class SpringIocMain {

    public static void main(String[] args) {

        /**
         *  加载配置文件
         * BeanFactory ：    加载配置文件时不会立马创建对象，使用的时候才会创建对象
         * ApplicationContext： 加载配置文件的时候就创建对象
         */
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("iocxml/bean.xml");
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("iocxml/bean.xml");
        // 创建对象
        Object user = beanFactory.getBean("user", SpringUser.class);
        System.out.println("user = " + user);

        // DI setter方法注入属性
        SpringBook springBook = (SpringBook)beanFactory.getBean("springBook", SpringBook.class);
        System.out.println("springBook = " + springBook);
        System.out.println("springBook = " + springBook.getName() + "-" + springBook.getBauthor());

        // DI 构造方法注入属性
        SpringBook springBook2 = (SpringBook)beanFactory.getBean("springBook2", SpringBook.class);
        System.out.println("springBook2 = " + springBook2);
        System.out.println("springBook2 = " + springBook2.getName() + "-" + springBook2.getBauthor());
    }
}
