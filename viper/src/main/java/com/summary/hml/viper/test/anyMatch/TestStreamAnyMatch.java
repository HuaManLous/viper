package com.summary.hml.viper.test.anyMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-07-05 11:03
 * @Description : anyMatch 的使用
 */
public class TestStreamAnyMatch {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("1112");
        list.add("1113");
        list.add("1114");
        boolean b = list.stream().anyMatch("1113"::equals);
        // 判断list中是否包含莫个参数
        if (list.contains("1113")) {
            System.out.println("包含");
        }

        // anyMatch 只有有一个满足情况就返回true
        if (list.stream().anyMatch("1113"::equals)) {
            System.out.println("anyMatch" + "包含成功");
        }

    }
}
