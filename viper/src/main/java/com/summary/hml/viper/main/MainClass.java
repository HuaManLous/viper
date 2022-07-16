package com.summary.hml.viper.main;

import java.util.Random;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2022-07-16 18:03
 * @Description : TODO
 */
public class MainClass {

    public static void main(String[] args) {

        // [0.0, 1)  5  10
        int num = (int) (Math.random() * 5 + 5);
        System.out.println("num = " + num);

        // [-5, 10)
        int v = (int) (Math.random() * 15 - 5);
        System.out.println("v = " + v);


        // Rand()
        Random random = new Random(2);
        // [5,10)
        int i = random.nextInt();
        System.out.println("i = " + i);

        // [5,10)   random.nexInt() 产生的数据是【0，1）
        int i2 = random.nextInt(5) + 5;
        System.out.println("i2 = " + i2);
        boolean b = random.nextBoolean();
        System.out.println("b = " + b);

        getNumArr();

        getYangHui();


    }

    /**
     * 随机产生一个六位不重复的数组
     */
    public static void getNumArr() {
        // 定义一个长度为6的数组
        int[] arr = new int[6];
        // 给数组赋值
        for (int i = 0; i < arr.length; i++) {
            // 生成一个[1,29)的随机数
            int num = (int) (Math.random() * 29 + 1);
            if (i >= 1) {
                for (int j = 0; j < i; j++) {
                    if (num == arr[j]) {
                        while (true) {
                            int newNumber = (int) (Math.random() * 29 + 1);
                            if (num != newNumber) {
                                num = newNumber;
                                j = -1;
                                break;
                            }
                        }
                    }
                }
            }
            arr[i] = num;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }

    /**
     * 杨辉三角
     */
    public static void getYangHui() {
        // 创建二维数组
        int[][] arr = new int[10][];

        // 二维数组赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            // 每行的首尾元素赋值
            arr[i][0] = 1;
            arr[i][i] = 1;
            // 每行的非首尾元素赋值
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

            }

        }

        // 输出二位数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
