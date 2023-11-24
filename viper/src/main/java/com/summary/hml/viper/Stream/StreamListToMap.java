package com.summary.hml.viper.Stream;

import com.summary.hml.viper.ssm.request.UserRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-11-24 15:20
 * @Description : 将List<UserRequest> 转换为Map<String, UserRequest>
 */
public class StreamListToMap {

    /**
     * 将List<UserRequest> 转换为Map<String, UserRequest>
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "李四", "王五");
        List<UserRequest> list1 = new ArrayList<>();
        list1.add(new UserRequest("张三", "2", new BigDecimal("18"), 1));
        list1.add(new UserRequest("李四", "2", new BigDecimal("18"), 1));
        list1.add(new UserRequest("王五", "2", new BigDecimal("18"), 1));
        Map<String, List<UserRequest>> collect = list1.stream().collect(Collectors.groupingBy(UserRequest::getName));
        for (int i = 0; i < list.size(); i++) {
            if (collect.containsKey("张三")) {
                System.out.println("i = " + i);
            }
        }
        Map<String, UserRequest> collect1 = list1.stream().collect(Collectors.toMap(UserRequest::getName, a -> a, (k, v) -> v));
        System.out.println("collect1 = " + collect1);
    }

}
