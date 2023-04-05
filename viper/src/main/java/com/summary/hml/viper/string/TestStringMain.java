package com.summary.hml.viper.string;

import java.util.Arrays;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-04-05 21:39
 * @Description : String类总结
 */
public class TestStringMain {

    public static final String IDENTIFIER = "%s";

    public static final Integer NUMBER = -1;

    public static void main(String[] args) {
        String str = "%sA%sB%sC%sE";
        char[] arr = {'B','D','F'};
        
        int arrLength = arr.length;
        String resultStr = str;

        // 记录字符串中莫个字符串出现的次数
        int count = 0;
        for (int i = 0; true; i++) {
            i = str.indexOf(IDENTIFIER, i);
            if (NUMBER != i) {
                count++;
                int index = count % arrLength;
                if (index == 0) {
                    resultStr = resultStr.replaceFirst(IDENTIFIER, String.valueOf(arr[arrLength - 1]));
                }else {
                    resultStr = resultStr.replaceFirst(IDENTIFIER, String.valueOf(arr[index - 1]));
                }
            }else {
                break;
            }
        }

        System.out.println("str = " + str + "   arr = " + Arrays.toString(arr) + "    resultStr = " + resultStr);

    }
}
