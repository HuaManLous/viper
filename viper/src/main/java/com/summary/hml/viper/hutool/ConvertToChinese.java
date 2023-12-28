package com.summary.hml.viper.hutool;

import cn.hutool.core.convert.Convert;

import java.math.BigDecimal;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-12-28 14:50
 * @Description : 转换类
 */
public class ConvertToChinese {
    
    public static BigDecimal money;

    public static void main(String[] args) {
        money = new BigDecimal("250");
        String s = Convert.digitToChinese(money);
        System.out.println("s = " + s);
        String s1 = Convert.numberToChinese(0.54D, true);
        System.out.println("s1 = " + s1);
    }
}
