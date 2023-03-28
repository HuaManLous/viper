package com.summary.hml.viper.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-28 11:24
 * @Description : 饿汉式
 */
public class HungrySingleton implements Serializable {

    /**
     *
     * 饿汉式
     *     优点 ： 线程安全，没有加各种锁，效率高
     *     缺点 ： 类加载的时候就初始化 不管用不用的到都会占用空间， 浪费内存
     */

    // 构造方法私有化
    private HungrySingleton() {}

    // 提供私有的静态的对象实例
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    // 提供公有的静态的获取对象实例的方法
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }


    /**
     * 虽然增加readResolve()方法返回实例解决了单例模式被破坏的问题，
     *     但是实际上实例化了两次，只不过新创建的对象没有被返回而已。
     */
    private Object readResolve() throws ObjectStreamException {
        return hungrySingleton;
    }

    public void method() {
        System.out.println(" ==== ");
    }

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        instance.method();
    }
}
