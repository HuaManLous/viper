package com.summary.hml.viper.spring_study.aop.logtest;

import com.alibaba.fastjson.JSON;
import com.summary.hml.viper.search.BubbleSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-29 14:42
 * @Description : 日志测试类
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        /**
         *  ERROR  <  WARN < INFO < DEBUG
         */
        try{
            throw new Exception("模拟");
        }catch (Exception e) {
            logger.error("error ==> " + e.getMessage());
        }

        int[] arr = {20,5,12,67,222,1,235,5};
        logger.info("LogTest ==> main()" + JSON.toJSONString(arr));

        BubbleSort.bubbleSort(arr);
        for (int value : arr) {
            System.out.println("value = " + value);
        }
    }




}
