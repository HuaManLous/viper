package com.summary.hml.viper.Stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : Stream流  中间操作符  去重filter
 */
public class StreamDistinctDemo {

    public static void main(String[] args) {
        distinct();
    }

    public static void distinct(){

        // 字符串
        List<String> list = Arrays.asList("aa","bb","cc","dd","aa");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        // 基本数据类型
        List<Object> list2 = Arrays.asList(11,222,333,4444,11);
        Object collect1 = list2.stream().distinct().collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        // 引用数据类型
        List<StreamDistinctBean> list3 = Arrays.asList(new StreamDistinctBean("张三",18),new StreamDistinctBean("张三",18),new StreamDistinctBean("张三",18),new StreamDistinctBean("张三",18) );
        Object collect2 = list3.stream().distinct().collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);
    }
}

class StreamDistinctBean{

    private String name;

    private int age;

    public StreamDistinctBean() {
    }

    public StreamDistinctBean(String name, int age) {
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (null == obj) {
           return false;
       }
       return true;
    }
}
