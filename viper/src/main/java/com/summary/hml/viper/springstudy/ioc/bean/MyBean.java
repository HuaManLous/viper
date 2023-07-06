package com.summary.hml.viper.springstudy.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 14:52
 * @Description : TODO
 */
public class MyBean implements FactoryBean<Dept> {


    @Override
    public Dept getObject() throws Exception {
        Dept dept = new Dept();
        dept.setName("factoryBean -- name ");
        dept.setAddress("factoryBean -- address ");
        return dept;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
    
    @Test
    public void test() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("iocxml/FactoryBean.xml");
        Dept myBeanDept = beanFactory.getBean("myBean", Dept.class);
        System.out.println("myBeanDept = " + myBeanDept);

    }
}
