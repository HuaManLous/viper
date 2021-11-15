package com.summary.hml.viper.lambda;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-10-29 15:17
 * @Description : 函数式接口可以有多个抽象方法
 */
public class SpecialFunctionalInterface {

    public static void main(String[] args) {
        Special special = (b,c) -> {
            return 1;
        };
    }

}

// 函数式接口，只能有一个抽象方法，但是object包下的方法可以
@FunctionalInterface
interface  Special{

    int compare(Object o1, Object o2);

    int hashCode();
}
