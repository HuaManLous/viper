package com.summary.hml.viper.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-11 17:02
 * @Description : 反射
 */
public class ReflectionThird {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("com.summary.hml.viper.reflection.Pig");
        Annotation[] annotations = c.getAnnotations();
        System.out.println("annotations.length = " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        // 通过反射获取注解的值
        Anno anno = (Anno) c.getAnnotation(Anno.class);
        System.out.println("anno.table() = " + anno.table());

        // 通过反射获取注解的值
        Method eat = c.getMethod("eat");
        AnnoByMethod annoByMethod = (AnnoByMethod) eat.getAnnotation(AnnoByMethod.class);
        System.out.println("annoByMethod.methodName() = " + annoByMethod.methodName());


    }
}

@Anno(table = "db_table")
class Pig {

    @AnnoByField(columnName = "id", type = "String", length = 3)
    private String id;

    @AnnoByField(columnName = "name", type = "String", length = 3)
    private String name;

    @AnnoByField(columnName = "age", type = "String", length = 3)
    private String age;

    @AnnoByMethod(methodName = "🐖吃食")
    public void eat() {
        System.out.println("吃好，睡好，玩好！！！");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Anno {

    String table() default "tb_";

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnoByField {

    String columnName() default "id";

    String type() default "int";

    int length() default 1;

}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnoByMethod {

    String methodName() default "";

}