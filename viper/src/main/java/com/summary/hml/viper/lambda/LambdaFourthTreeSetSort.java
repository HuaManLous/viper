package com.summary.hml.viper.lambda;

import java.util.Set;
import java.util.TreeSet;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : treeSet排序
 */
public class LambdaFourthTreeSetSort {

    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<>();
        set.add(new Person2("画满楼_01",10));
        set.add(new Person2("画满楼_02",11));
        set.add(new Person2("画满楼_03",12));
        set.add(new Person2("画满楼_04",9));
        set.add(new Person2("画满楼_05",8));
        set.add(new Person2("画满楼_06",7));
        set.add(new Person2("画满楼_07",50));
        set.add(new Person2("画满楼_08",50));

    }

}
