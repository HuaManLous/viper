package com.summary.hml.viper.lambda;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : lambda创建线程
 */
public class LambdaEighthThread {

    Runnable run = new Runnable() {
        @Override
        public void run() {
            System.out.println("匿名内部类的方式创建线程");
        }
    };

    Runnable runLambda = () -> {
        System.out.println("lambda创建线程");
    };

}
