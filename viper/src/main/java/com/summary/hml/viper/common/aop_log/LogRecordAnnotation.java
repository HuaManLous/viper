package com.summary.hml.viper.common.aop_log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public @interface LogRecordAnnotation {

    /**
     * 业务类型  1：事件 2：因子 3：动作 4：策略
     *
     * @return
     */
    String bizType();

    /**
     * 操作类型 1：添加 2：修改 3：删除 4：停用 5：启用
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
