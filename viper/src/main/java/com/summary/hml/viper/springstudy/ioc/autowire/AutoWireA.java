package com.summary.hml.viper.springstudy.ioc.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 22:40
 * @Description : TODO
 */
public class AutoWireA {

    private AutoWireB autoWireB;

    public AutoWireB getAutoWireB() {
        return autoWireB;
    }

    public void setAutoWireB(AutoWireB autoWireB) {
        this.autoWireB = autoWireB;
    }

    @Override
    public String toString() {
        return "AutoWireA{" +
                "autoWireB=" + autoWireB +
                '}';
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/AutoWire.xml");
        AutoWireA autoWireA = applicationContext.getBean("autoWireA", AutoWireA.class);
        System.out.println("autoWireA = " + autoWireA);
    }
}
