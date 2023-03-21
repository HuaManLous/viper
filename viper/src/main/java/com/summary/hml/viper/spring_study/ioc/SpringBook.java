package com.summary.hml.viper.spring_study.ioc;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 18:21
 * @Description : TODO
 */
public class SpringBook {

    private String name;

    private String bauthor;

    public void setName(String name) {
        this.name = name;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getName() {
        return name;
    }

    public String getBauthor() {
        return bauthor;
    }

    public SpringBook(){

    }

    public SpringBook(String name, String bauthor) {
        this.name = name;
        this.bauthor = bauthor;
    }
}
