package com.summary.hml.viper.ssm.controller;

import com.summary.hml.viper.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
