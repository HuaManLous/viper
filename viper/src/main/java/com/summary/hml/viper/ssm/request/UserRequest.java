package com.summary.hml.viper.ssm.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-08-14 14:17
 * @Description : TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String address;

    private BigDecimal num;

    private int age;

    public static void main(String[] args) {
      String str = "18338354114";
      if (str.startsWith("测试")) {
          System.out.println("str = " + str);
      }
        System.out.println("2 = " + 2);


        System.out.println("10000" + str.substring(5));

    }


}
