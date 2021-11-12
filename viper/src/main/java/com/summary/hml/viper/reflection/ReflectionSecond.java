package com.summary.hml.viper.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-11 17:02
 * @Description : 反射
 */
public class ReflectionSecond {

    public static void main(String[] args) throws Exception{
        Class<?> c1 = Class.forName("com.summary.hml.viper.reflection.Student");
        // 1。获取包名和类名
        String name = c1.getName();
        System.out.println("获取类的名字(包名和类名)："+ name);
        // 2。获取类名
        String simpleName = c1.getSimpleName();
        System.out.println("获取类名:"+simpleName);
        // 3.获得类的属性只能是public
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println("属性:"+field);
        }

        // 3.获取全部属性
        Field[] declaredField = c1.getDeclaredFields();
        for (Field f : declaredField ) {
            System.out.println("全部属性:"+f);
        }

        // 4.获取指定的属性
        Field name1 = c1.getField("name");
        System.out.println("指定的属性："+name1);

        // 5.获取方法-并执行方法
        Constructor<?> constructor = c1.getConstructor();
        Student student = (Student)constructor.newInstance();
        Method study = c1.getMethod("study",String.class);
        study.invoke(student,"花满楼");

        // 6.给属性赋值
        Field age = c1.getDeclaredField("age");
        // 私有要关闭
        age.setAccessible(true);
        age.set(student,"1");
        System.out.println(student);

        // 5.通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation anno : annotations){
            System.out.println("类上的注解"+anno);
        }

    }

}

@AnnotationWithReflectionType("student类上")
class Student{

    @AnnotationWithReflectionField(name = "花满楼",value = "3")
    public String name;

    @AnnotationWithReflectionField(name = "花满楼2",value = "4")
    private String age;

    //@AnnotationWithReflection(name = "花满楼-自定义")
    public void study(String name){
        System.out.println(name + ":学习");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface AnnotationWithReflection{
    String name() default "花满楼";
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface AnnotationWithReflectionType{
    String value() default "类上";
}


@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface AnnotationWithReflectionField{
    String value() default "属性上";
    String name() default "张三";
}
