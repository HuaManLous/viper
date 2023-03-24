package com.summary.hml.viper.spring_study.aop.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-24 22:37
 * @Description : TODO
 */

@Component
@Aspect
public class UserProxy {

    /**
     * execution([权限修饰符][返回值][全名类路径][方法名][参数列表])
     * execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))
     */

    @Before(value = "execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))")
    public void before() {
        System.out.println("before ......");
    }

    @After(value = "execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))")
    public void after() {
        System.out.println("after ......");
    }

    @Around(value = "execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 切入点方法前执行
        System.out.println("around before ......");
        // 执行切入点方法
        proceedingJoinPoint.proceed();
        // 切入点方法后执行
        System.out.println("around after ......");
    }

    @AfterThrowing(value = "execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }

    @AfterReturning(value = "execution(* com.summary.hml.viper.spring_study.aop.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }






}
