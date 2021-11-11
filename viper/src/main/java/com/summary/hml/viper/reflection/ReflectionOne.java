package com.summary.hml.viper.reflection;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-11 15:52
 * @Description : 反射
 */
public class ReflectionOne {

    public static void main(String[] args) throws ClassNotFoundException {
        // 反射获取对象的几种方式
        // 1.Class.forName();
        Class c1 = Class.forName("com.summary.hml.viper.reflection.Person");
        // 2.对象.getClass();
        Person person = new Person();
        Class c2 = person.getClass();
        // 3.类.class
        Class c3 = Person.class;

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

    }
}

class Person{
    String name;
    String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
