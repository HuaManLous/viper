package com.summary.hml.viper.springstudy.ioc.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 15:59
 * @Description : bean的生命周期
 */
public class BeanLifeCycle {

    private String name;

    public BeanLifeCycle(){
        System.out.println("第一步 调用构造方法创建bean实例");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步 调用setter方法给属性赋值");
    }

    public void initMethod() {
        System.out.println("第四步 调用初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第七步 关闭容器后 调用销毁方法");
    }

    @Test
    public void test() {
        /*
            BeanFactory 加载配置文件时不会立马创建对象
            ApplicationContext 加载配置文件时会立马创建对象
         */
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("iocxml/BeanLifeCycle.xml");
        BeanLifeCycle beanLifeCycle = classPathXmlApplicationContext.getBean("beanLifeCycle", BeanLifeCycle.class);
        System.out.println("第六步 对象可以使用了");
        System.out.println(beanLifeCycle);

        // 关闭容器
        classPathXmlApplicationContext.close();


    }



}
