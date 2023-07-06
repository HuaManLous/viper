package com.summary.hml.viper.springstudy.ioc;

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

    private String address;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public SpringBook(String name, String author, String address) {
        this.name = name;
        this.author = author;
        this.address = address;
    }

    public SpringBook(String name, String author, String address, String price) {
        this.name = name;
        this.author = author;
        this.address = address;
        this.price = price;
    }

    @Override
    public String toString() {
        return "SpringBook{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
