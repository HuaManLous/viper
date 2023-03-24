package com.summary.hml.viper.spring_study.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-24 10:30
 * @Description : TODO
 */
public class JdkProxy {

    public static void main(String[] args) {

        Class[] interfaces = {ProxyUserDao.class};

        ProxyUserDao proxyUserDao = (ProxyUserDao)Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new ProxyUserDaoImplDaiLi(new ProxyUserDaoImpl()));
        proxyUserDao.add("aa","bb");
    }

    static class ProxyUserDaoImplDaiLi implements InvocationHandler{

        private Object obj;

        public ProxyUserDaoImplDaiLi(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 被代理对象的方法之前执行
            System.out.println("代理之前执行了 。。。。");

            // 被代理的方法
            Object invoke = method.invoke(obj,args);

            // 代理方法之后执行
            System.out.println("代理之后执行了 。。。。");

            return null;
        }
    }

}
