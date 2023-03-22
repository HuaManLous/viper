package com.summary.hml.viper.spring_study.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 14:52
 * @Description : TODO
 */
public class MyBeanSingle {

    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("iocxml/FactoryBean.xml");

        MyBeanSingle myBeanSingle = beanFactory.getBean("myBeanSingle", MyBeanSingle.class);
        MyBeanSingle myBeanSingle2 = beanFactory.getBean("myBeanSingle", MyBeanSingle.class);
        System.out.println("myBeanSingle = " + myBeanSingle);
        System.out.println("myBeanSingle2 = " + myBeanSingle2);

    }
}
