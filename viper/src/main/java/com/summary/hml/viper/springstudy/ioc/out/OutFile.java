package com.summary.hml.viper.springstudy.ioc.out;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 22:59
 * @Description : 外部属性文件
 */
public class OutFile {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OutFIle{" +
                "name='" + name + '\'' +
                '}';
    }
    
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/OutFile.xml");
        OutFile outFile = applicationContext.getBean("outFile", OutFile.class);
        System.out.println("outFile = " + outFile);

    }
}
