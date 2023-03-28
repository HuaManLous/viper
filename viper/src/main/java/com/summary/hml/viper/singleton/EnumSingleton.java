package com.summary.hml.viper.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-28 13:58
 * @Description : 枚举式单例
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    /**
     *
     * 枚举式单例模式，可以防止序列化，但是不能用于反射
     */


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance = EnumSingleton.getInstance();
        System.out.println("instance = " + instance);
        EnumSingleton instance2 = EnumSingleton.getInstance();
        System.out.println("instance2 = " + instance2);
        System.out.println("instance2 = " + EnumSingleton.INSTANCE);

        // 反射
        Class<EnumSingleton> enumSingletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> declaredConstructor = enumSingletonClass.getDeclaredConstructor();
        // 没有无参构造方法
        EnumSingleton enumSingleton = declaredConstructor.newInstance();
        System.out.println("enumSingleton = " + enumSingleton);
    }

}
