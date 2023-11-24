package com.summary.hml.viper.hutool;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.CountDownLatch;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-11-24 15:10
 * @Description : 测试ThreadUtil.execAsync()
 */
public class ThreadUtilMain {

    public static void main(String[] args) throws InterruptedException {

        test1();

        System.out.println(" =================================== ");

        try {
            for (int i = 0; i < 5; i++) {
                ThreadUtil.execAsync(() -> {
                    int num = RandomUtil.randomInt(1000, 4000);
                    System.out.println(num);
                });
                System.out.println("第个线程:" + i);
            }
            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 多线程实现线程等待的功能，所有线程的任务都指向完成后主线程才可以往下走
     *
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        //初始化线程数量
        CountDownLatch countDownLatch = ThreadUtil.newCountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            ThreadUtil.execute(() -> {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("第" + i + "个线程");
            //调用线程计数器-1
            countDownLatch.countDown();
        }
        //唤醒主线程
        countDownLatch.await();
        System.out.println("完成");
    }
}
