package com.summary.hml.viper.ssm.controller;

import com.summary.hml.viper.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 16:55
 * @Description : TestController
 */

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("use")
    public String get() {
        return testService.getById("11");
    }

    @RequestMapping("use2/{id}")
    public String get2(@PathVariable("id") String id) {
        return testService.getById(id);
    }

    @RequestMapping("use3/")
    public String get3(@RequestParam String id) {
        return testService.getById(id);
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        // 找到交集
        List<Integer> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("交集：" + intersection);

        // 找到list1中与list2不同的部分
        List<Integer> difference1 = new ArrayList<>(list1);
        difference1.removeAll(intersection);
        System.out.println("list1中与list2不同的部分：" + difference1);

        // 找到list2中与list1不同的部分
        List<Integer> difference2 = new ArrayList<>(list2);
        difference2.removeAll(intersection);
        System.out.println("list2中与list1不同的部分：" + difference2);
    }

}
