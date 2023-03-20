package com.summary.hml.viper.common.aop_log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-28 11:09
 * @Description : 切面
 */

@Aspect
@Component
public class LogRecordAop {

    /**
     * 切点
     */
    @Pointcut(value = "@annotation(com.summary.hml.viper.common.aop_log.LogRecordAnnotation)")
    public void cutService(){

    }

    @AfterReturning(value = "cutService()", returning = "retValue")
    public void afterReturningRecordSysLog(JoinPoint joinpoint, Object retValue){
        System.out.println("AfterReturning 进来了");
        System.out.println("retValue = " + retValue);
    }










}
