package com.summary.hml.viper.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-28 11:53
 * @Description : 懒汉式静态内部类
 */
public class LazyInnerClassSingleton implements Serializable {

    // 1。静态内部类
    private static class InnerSingleton{
        private static final LazyInnerClassSingleton lazyInnerClassSingleton = new LazyInnerClassSingleton();
    }

    // 2.构造方法私有化
    private LazyInnerClassSingleton(){
        if (null != InnerSingleton.lazyInnerClassSingleton) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    // 3.
    public static final LazyInnerClassSingleton getInstance(){
        return InnerSingleton.lazyInnerClassSingleton;
    }

    public LazyInnerClassSingleton readResolve(){
        return InnerSingleton.lazyInnerClassSingleton;
    }



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton instance2 = LazyInnerClassSingleton.getInstance();
        System.out.println("instance = " + instance);
        System.out.println("instance2 = " + instance2);
        Class<LazyInnerClassSingleton> lazyInnerClassSingletonClass = LazyInnerClassSingleton.class;
        Constructor<LazyInnerClassSingleton> declaredConstructor = lazyInnerClassSingletonClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyInnerClassSingleton lazyInnerClassSingleton = declaredConstructor.newInstance();
        System.out.println("lazyInnerClassSingleton = " + lazyInnerClassSingleton);

    }
}
