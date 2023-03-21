package com.summary.hml.viper.spring_study.ioc.bean;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 22:33
 * @Description : 部门
 */
public class Dept {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "dept{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
