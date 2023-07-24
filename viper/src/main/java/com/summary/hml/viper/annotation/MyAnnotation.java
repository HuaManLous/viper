package com.summary.hml.viper.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-11 11:19
 * @Description : 练习注解
 */
public class MyAnnotation {

    @AnnotationOne("花好月圆")
    public static void main(String[] args) {
        System.out.println("团团圆圆");
    }
}

// 四个元注解
// 注解作用位置
@Target(value = ElementType.METHOD)
// 注解有效范围
@Retention(value = RetentionPolicy.RUNTIME)
// 是否生成文档
@Documented
// 子类是否继承
@Inherited
@interface AnnotationOne {

    // 参数类型  参数名
    String value();

    // 默认值
    String name() default "花满楼";

    // 参数类型enum class String
    String[] address() default {"上海", "广州", "海南"};

}
