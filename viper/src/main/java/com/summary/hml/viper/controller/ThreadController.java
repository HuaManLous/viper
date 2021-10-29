package com.summary.hml.viper.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 10:27
 * @Description : TODO
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @RequestMapping("/first")
    public User first(@RequestBody Person person){
        User user = new User();
        user.setAge(18);
        user.setName("花满楼-男");
        if (null != person && !"男".equals(person.getSex())) {
            user.setName("花满楼-女");
        }
        return user;
    }
}

class User{
   private String name;
   private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person{
    private String sex;
    private Integer age;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}