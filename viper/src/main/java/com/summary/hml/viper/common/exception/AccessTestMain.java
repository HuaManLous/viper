package com.summary.hml.viper.common.exception;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 11:21
 * @Description : 测试类
 */
public class AccessTestMain {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            i += 1;
            if (i == 3) {
                throw new BaseException("未知业务异常", ErrorCode.UNKNOWN_VOCATIONAL_EXCEPTION);
            }
        }

    }

}
