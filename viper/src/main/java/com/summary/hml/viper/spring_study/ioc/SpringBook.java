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

    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SpringBook(){

    }

    public SpringBook(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "SpringBook{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
