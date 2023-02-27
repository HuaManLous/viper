package com.summary.hml.viper.lambda;

import java.util.Set;
import java.util.TreeSet;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : treeSet排序  set不可重复/无序
 */
public class LambdaFourthTreeSetSort {

    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<Person2>((o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });
        set.add(new Person2("画满楼_01", 10));
        set.add(new Person2("画满楼_02", 11));
        set.add(new Person2("画满楼_03", 12));
        set.add(new Person2("画满楼_04", 9));
        set.add(new Person2("画满楼_05", 8));
        set.add(new Person2("画满楼_06", 7));
        set.add(new Person2("画满楼_07", 50));
        set.add(new Person2("画满楼_08", 50));
        System.out.println("set = " + set);

        // 上面的代码打印的只能是不重复的
        Set<Person2> set2 = new TreeSet<Person2>((o1, o2) -> {
            if (o1.getAge() >= o2.getAge()) {
                return 1;
            }
            return -1;
        });
        set2.add(new Person2("画满楼_01", 10));
        set2.add(new Person2("画满楼_02", 11));
        set2.add(new Person2("画满楼_03", 12));
        set2.add(new Person2("画满楼_04", 9));
        set2.add(new Person2("画满楼_05", 8));
        set2.add(new Person2("画满楼_06", 7));
        set2.add(new Person2("画满楼_07", 50));
        set2.add(new Person2("画满楼_08", 50));
        System.out.println("set2 = " + set2);


        Set<Person2> set3 = new TreeSet<Person2>((o1, o2) -> {
            // 通过三目运算符
            return o1.getAge() - o2.getAge() >= 0 ? 1 : -1;
        });
        set3.add(new Person2("画满楼_01", 10));
        set3.add(new Person2("画满楼_02", 11));
        set3.add(new Person2("画满楼_03", 12));
        set3.add(new Person2("画满楼_04", 9));
        set3.add(new Person2("画满楼_05", 8));
        set3.add(new Person2("画满楼_06", 7));
        set3.add(new Person2("画满楼_07", 50));
        set3.add(new Person2("画满楼_08", 50));
        System.out.println("set3 = " + set3);

    }

}
