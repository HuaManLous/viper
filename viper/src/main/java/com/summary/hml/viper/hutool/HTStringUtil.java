package com.summary.hml.viper.hutool;

import cn.hutool.core.util.StrUtil;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-12-28 11:21
 * @Description : String 工具类
 */
public class HTStringUtil {

    public static void main(String[] args) {
        String str = "22";
        //String str = "22222";
        // 向后拼接 长度超过length就截取
        String s = StrUtil.padAfter(str, 4, "0");
        System.out.println("str = " + s);
        // 向前拼接
        String s1 = StrUtil.padPre(str, 4, "0");
        System.out.println(" s1= " + s1);
    }

}
