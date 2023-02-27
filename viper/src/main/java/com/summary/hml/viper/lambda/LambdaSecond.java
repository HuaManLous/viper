package com.summary.hml.viper.lambda;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : lambda  方法的引用
 */
public class LambdaSecond {

    public static void main(String[] args) {

        LambdaDemo1 lambdaDemo = (a) -> {
            return a * 2;
        };
        // 一个参数可以去掉()
        lambdaDemo = a -> {
            return a * 2;
        };
        // 有返回值时如果想去掉{}，必须去掉return
        lambdaDemo = a -> a * 2;

        /**
         * 方法的引用
         *    可以快速的将一个lambda表达式的实现指向一个已经实现的方法
         *    语法: 方法的隶属者::方法名
         *
         */
        LambdaDemo1 lambdaDemo1 = a -> change(a);
        int lam = lambdaDemo1.lam(2);
        System.out.println("lam = " + lam);

        // 静态方法隶属于类
        LambdaDemo1 lambdaDemo2 = LambdaSecond::change;
        int lam1 = lambdaDemo2.lam(5);
        System.out.println("lam1 = " + lam1);

        // 普通方法隶属于对象
        LambdaDemo1 lambdaDemo3 = new LambdaSecond()::change2;
        int lam2 = lambdaDemo3.lam(10);
        System.out.println("lam2 = " + lam2);

        /**
         *
         * 构造方法的引用
         *
         *
         */
        LambdaDemo2 lambdaDemo21 = () -> new Person();
        // 获取无参构造
        LambdaDemo2 lambdaDemo22 = Person::new;
        lambdaDemo22.getPerson();

        LambdaDemo3 lambdaDemo31 = (a, b) -> new Person(a, b);
        // 获取有参构造
        LambdaDemo3 lambdaDemo23 = Person::new;
        lambdaDemo23.getPerson("花满楼", 18);

    }

    public static int change(int a) {
        return a * 2;
    }

    ;

    public int change2(int a) {
        return a * 2;
    }

    ;

}


interface LambdaDemo1 {

    int lam(int a);
}

interface LambdaDemo2 {

    Person getPerson();
}

interface LambdaDemo3 {

    Person getPerson(String b, int a);
}


class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }

    public Person() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
};




