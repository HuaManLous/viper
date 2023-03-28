package com.summary.hml.viper.search;

import java.util.Arrays;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-27 16:57
 * @Description : 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = random();
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
              if (arr[j] > arr[j+1]) {
                  int temp = arr[j+1];
                  arr[j+1] = arr[j];
                  arr[j] = temp;
                  flag = true;
              }
            }

            if (flag = false) {
               break;
            }
        }

        for (int value : arr) {
            System.out.println("arr = " + value);
        }

    }

    public static int[] random() {
        // [0, 1)     6~50
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = (int) (Math.random() * 44 + 6);
        }
        return arr;
    }
}
