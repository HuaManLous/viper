package com.summary.hml.viper.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-21 10:19
 * @Description : 跳出lambda表达式
 */
public class AnyMatch {

    public static void main(String[] args) {
        
        List<Object> objects = new ArrayList<>();
        // 因为lambda.foreach不能跳出循环
        List<String> list = Arrays.asList("11", "22", "33");
        list.stream().anyMatch( str -> {
            objects.add(str);
            boolean flag = false;
            if (str.equals("22")) {
                objects.add("44");
                flag = true;
            }
            return flag;
        });
        System.out.println("objects = " + objects);

        // 有一个结果为true的时候终止
        boolean b = objects.stream().anyMatch(str -> str.equals("44"));
        System.out.println("b = " + b);



    }
}
