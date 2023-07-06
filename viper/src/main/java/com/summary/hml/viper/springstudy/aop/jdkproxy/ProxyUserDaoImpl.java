package com.summary.hml.viper.springstudy.aop.jdkproxy;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-24 10:32
 * @Description : TODO
 */
public class ProxyUserDaoImpl implements ProxyUserDao{
    @Override
    public void add(String a, String b) {
        System.out.println("daoImpl add...." + a + b);
    }

    @Override
    public void update(String a) {
        System.out.println("daoImpl update...." + a);
    }
}
