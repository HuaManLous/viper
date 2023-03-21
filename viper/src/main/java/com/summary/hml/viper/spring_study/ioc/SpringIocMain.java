package com.summary.hml.viper.spring_study.ioc;

import com.summary.hml.viper.spring_study.ioc.service.UserService;
import org.springframework.beans.factory.BeanFactory;
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
        // 1 创建对象
        Object user = beanFactory.getBean("user", SpringUser.class);
        System.out.println("user = " + user);

        // 2 DI setter方法注入属性
        SpringBook springBook = (SpringBook)beanFactory.getBean("springBook", SpringBook.class);
        System.out.println("springBook = " + springBook);

        // 3 DI 构造方法注入属性
        SpringBook springBook2 = (SpringBook)beanFactory.getBean("springBook2", SpringBook.class);
        System.out.println("springBook2 = " + springBook2);

        // 4 DI p命名空间方法注入属性
        SpringBook springBook3 = (SpringBook)beanFactory.getBean("springBook3", SpringBook.class);
        System.out.println("springBook3 = " + springBook3);

        // 5 注入外部bean
        BeanFactory OutSideBeanBeanFactory = new ClassPathXmlApplicationContext("iocxml/OutSideBean.xml");
        UserService userService = OutSideBeanBeanFactory.getBean("userService", UserService.class);
        userService.add();
    }
}
