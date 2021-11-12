package com.summary.hml.viper.lambda;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : lambda
 */
public class LambdaOne {

    public static void main(String[] args) {
        /**
         * lambda是函数式
         * 返回值 方法名 参数列表 方法体
         * lambda表达式，只用在意参数列表和方法体
         *                 () -> {}
         */

        /**
         * 1. 当接口的参数是一个时可以省略()
         * 2. 参数类型可以省略，但是要省略就都省略，不省略就都不省略
         * 3. 有返回值时，如果只是一行返回时，如果省略{}，必须省略return
         */



        // 1.没有返回值，没有参数
        A a = () -> {
            System.out.println("没有返回值，没有参数");
        };
        a.get();

        // 1.没有返回值，有一个参数
        B b = bp -> {
            System.out.println("没有返回值，有一个参数");
        };
        b.get(2);

        // 没有返回值，有多个参数
        C c = (cp,cp2) -> {
            System.out.println("没有返回值，有多个参数");
        };
        c.get(1,1);

        // 有返回值，没有参数
        D d = () -> {
            return "花满楼";
        };
        String s = d.get();
        System.out.println(s);

        // 有返回值，有一个参数
        E e = (ep) -> {
            return "花满楼";
        };
        String s1 = e.get(1);
        System.out.println("s1 = " + s1);

        // 有返回值，有多个参数
        F f = (fp,fp2) -> {
            return "花满楼";
        };
        String s2 = f.get(1, 1);
        System.out.println("s2 = " + s2);






    }



}

// 没有返回值，没有参数
interface A {
    void get();
}

// 没有返回值，有一个参数
interface B {
    void get(int b);
}

// 没有返回值，有多个参数
interface C {
    void get(int b,int c);
}


// 有返回值，没有参数
interface  D{
    String get();
}

// 有返回值，有一个参数
interface  E{
    String get(int e);
}

// 有返回值，有多个参数
interface  F{
    String get(int e,int f);
}