package com.summary.hml.viper.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : Stream流  中间操作符  过滤filter
 */
public class StreamFilterDemo {

    public static void main(String[] args) {
        filter();
    }

    public static void filter(){
        List<String> list = Arrays.asList("ab","bf","cd","ef","ge","baba","mama","nainai");
        List<String> f = list.stream().filter(str -> str.contains("f")).collect(Collectors.toList());
        System.out.println("f = " + f);
    }
}
