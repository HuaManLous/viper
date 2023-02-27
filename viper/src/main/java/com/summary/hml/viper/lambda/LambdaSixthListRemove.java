package com.summary.hml.viper.lambda;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : list集合移除指定的元素
 */
public class LambdaSixthListRemove {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("2222");
        list.add("1111");
        list.add("5555");

        // 通过迭代的方式移除指定元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("1111".equals(iterator.next())) {
                iterator.remove();
            }
        }

        // 通过lambda方式移除指定的元素
        list.removeIf(e -> {
            if (e.equals("2222")) {
                return true;
            }
            return false;
        });

        System.out.println("list = " + list);
    }

}
