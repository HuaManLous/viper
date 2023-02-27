package com.summary.hml.viper.lambda;

import java.util.ArrayList;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : 集合的遍历
 */
public class LambdaFifthListForeach {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("2222");
        list.add("1111");
        list.add("5555");
        list.forEach((a) -> {
            System.out.println("a = " + a);
        });
        // 方法的引用
        list.forEach(System.out::println);


    }


}
