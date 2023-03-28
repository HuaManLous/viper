package com.summary.hml.viper.singleton;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-28 11:22
 * @Description :  懒汉式双重校验
 */
public class LazySingletonDoubleCheck {

    /**
     *  懒汉式
     *    优点 ： 线程安全，使用时才会创建对象
     *    缺点 ： 加锁 性能有影响
     */

    // 构造方法私有化
    private LazySingletonDoubleCheck() { }

    // 提供私有的静态对象实例
    private static LazySingletonDoubleCheck lazySingleton = null;

    // 提供公有的静态获取实例的方法
    public static LazySingletonDoubleCheck getInstance() {
        if (null == lazySingleton) {
            synchronized(LazySingletonDoubleCheck.class){
                if (null == lazySingleton) {
                    lazySingleton = new LazySingletonDoubleCheck();
                }
            }
        }
        return lazySingleton;
    }

    public void test() {
        System.out.println("lazySingleton = " + lazySingleton);
    }

    public static void main(String[] args) {
        LazySingletonDoubleCheck instance = LazySingletonDoubleCheck.getInstance();
        LazySingletonDoubleCheck instance2 = LazySingletonDoubleCheck.getInstance();
        instance.test();
        instance2.test();
    }

}
