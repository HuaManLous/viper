package com.summary.hml.viper.spring_study.ioc.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 22:35
 * @Description : 员工类
 */
public class Emp {

    private List<String> love;

    private String name;

    private int age;

    private Dept dept;

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }



    @Test
    public void test(){
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/InnerClassBean.xml");
        Emp emp = applicationContext.getBean("emp", Emp.class);
        System.out.println("emp = " + JSON.toJSONString(emp));

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",null);
        hashMap.put("age",18);
        // JSON.toJSONString 会去掉null值
        System.out.println("JSON.toJSONString(hashMap) = " + JSON.toJSONString(hashMap));

        System.out.println("JSON.toJSONString(hashMap, null) = " + JSON.toJSONString(hashMap, SerializerFeature.WriteNullStringAsEmpty));

    }
}
