package com.summary.hml.viper.springstudy.aop.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-25 00:14
 * @Description : TODO
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.summary.hml.viper.springstudy.aop.aopanno.User.add(..))")
    public void before() {
        System.out.println("PersonProxy before ......");
    }

}
