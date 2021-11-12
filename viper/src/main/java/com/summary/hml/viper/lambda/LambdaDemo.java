package com.summary.hml.viper.lambda;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : TODO
 */
public class LambdaDemo {


    // 2.通过静态内部累类
    static class Dog implements Animal{
        @Override
        public void eat() {
            System.out.println("==>狗吃肉🔥");
        }
    }

    public static void main(String[] args) {

        // cat
        Animal cat = new Cat();
        cat.eat();

        // dog
        Animal dog = new Dog();
        dog.eat();

        // 3.通过创建局部内部类
        class Bird implements Animal{
            @Override
            public void eat() {
                System.out.println("==>鸟吃虫子🐛");
            }
        }
        // Bird
        Animal bird = new Bird();
        bird.eat();

        // 4.通过匿名内部类
        Animal unknown = new Animal() {
            @Override
            public void eat() {
                System.out.println("==>奥特曼打小怪兽👾");
            }
        };
        // unknow
        unknown.eat();

        // 5.通过lambda表达式
        /**
         * lambda是匿名函数
         *   函数接口是只包含一个抽象方法的接口
         *
         */
        Animal lambda = () -> {
            System.out.println("==>lambda+lambda");
        };
        lambda.eat();

    }

}



interface Animal{

    void eat();
}

// 1.通过创建累实现接口
class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("==>猫吃鱼🐟");
    }
}


