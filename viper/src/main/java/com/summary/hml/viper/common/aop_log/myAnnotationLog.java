package com.summary.hml.viper.common.aop_log;

import java.lang.annotation.*;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 12:45
 * @Description : 自定义注解
 */
@Inherited
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotationLog {

    /**
     * 业务类型
     *
     * @return
     */
    String bizType();

    /**
     * 操作类型
     *
     * @return
     */
    String operatorType();

    /**
     * 业务ID
     *
     * @return
     */
    String bizId() default "";

    /**
     * 方法描述
     *
     * @return
     */
    String desc() default "";


}
