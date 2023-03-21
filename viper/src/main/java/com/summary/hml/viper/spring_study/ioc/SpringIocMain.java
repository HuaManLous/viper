package com.summary.hml.viper.spring_study.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 00:56
 * @Description : TODO
 */
public class SpringIocMain {

    public static void main(String[] args) {
        // 加载配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("iocxml/bean.xml");
        // 创建对象
        Object user = beanFactory.getBean("user", SpringUser.class);
        System.out.println("user = " + user);
        SpringBook springBook = (SpringBook)beanFactory.getBean("springBook", SpringBook.class);
        System.out.println("springBook = " + springBook);
        System.out.println("springBook = " + springBook.getName() + "-" + springBook.getBauthor());
    }
}
