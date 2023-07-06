package com.summary.hml.viper.springstudy.ioc.autowire;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 22:40
 * @Description : TODO
 */
public class AutoWireB {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AutowireB{" +
                "name='" + name + '\'' +
                '}';
    }
}
