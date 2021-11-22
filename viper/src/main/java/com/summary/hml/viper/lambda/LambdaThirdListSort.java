package com.summary.hml.viper.lambda;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : lambda 集合排序
 */
public class LambdaThirdListSort {

    public static void main(String[] args) {

        ArrayList<Person2> list = new ArrayList<>();
        list.add(new Person2("画满楼_01",10));
        list.add(new Person2("画满楼_02",11));
        list.add(new Person2("画满楼_03",12));
        list.add(new Person2("画满楼_04",9));
        list.add(new Person2("画满楼_05",8));
        list.add(new Person2("画满楼_06",7));
        list.add(new Person2("画满楼_07",50));
        list.add(new Person2("画满楼_08",50));

        list.sort((o1,o2)->{
            // 返回正数表示前面的大
            return o1.getAge() - o2.getAge();
        });
        System.out.println(list);

        // 基本数据类型的排序
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(9);
        list2.add(8);
        list2.add(50);
        list2.add(50);
        list2.add(11);
        list2.add(12);
        list2.add(13);

        // 方法一通过collections工具类
        Collections.sort(list2);
        System.out.println(list2);

        // 通过lambda表达式方法
        list2.sort((o1,o2) -> {
            return o1 - o2;
        });
        System.out.println(list2);
    }

}


class Person2{

    private String name;

    private int age;

    public Person2() {
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}