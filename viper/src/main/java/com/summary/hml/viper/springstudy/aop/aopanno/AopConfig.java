package com.summary.hml.viper.springstudy.aop.aopanno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-25 00:36
 * @Description : aspect配置类
 */
@Configuration
@ComponentScan("com.summary.hml.viper.springstudy.aop.aopanno")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

    // 完全注解开发  可以省略下面的配置文件步骤
    /**
     *  <context:component-scan base-package="com.summary.hml.viper.spring_study"/>
     *  <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
     *
     */


}
