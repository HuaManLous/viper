package com.summary.hml.viper.test.stopwatch;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-05-31 17:09
 * @Description : 测试StopWatch
 */
public class TestStopWatchMain {

    public static void main(String[] args) throws InterruptedException {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("A");
        Thread.sleep(100);
        stopWatch.stop();

        stopWatch.start("B");
        Thread.sleep(100);
        stopWatch.stop();

        // 打印所有耗时
        System.out.println("stopWatch = " + stopWatch.getTotalTimeMillis());

        // 打印所有的任务信息
        System.out.println("JSON.toJSONString(stopWatch.getTaskInfo() = " + JSON.toJSONString(stopWatch.getTaskInfo()));

        // 打印最后一次的任务信息
        System.out.println("JSON.toJSONString(stopWatch.getLastTaskInfo() = " + JSON.toJSONString(stopWatch.getLastTaskInfo()));

        StopWatch.TaskInfo[] taskInfo = stopWatch.getTaskInfo();
        for (int i = taskInfo.length - 1; i >= 0; i--) {
            StopWatch.TaskInfo info = taskInfo[i];

            // 任务名称
            String taskName = info.getTaskName();
            // 任务花费秒
            double timeSeconds = info.getTimeSeconds();
            // 任务花费毫秒
            long timeMillis = info.getTimeMillis();
            // 任务花费纳秒   1秒 = 1000毫秒    1毫秒 = 1000000纳秒
            long timeNanos = info.getTimeNanos();

            System.out.println("详情：" + taskName +"/" + timeSeconds + "/" + timeMillis + "/" + timeNanos);
        }


        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());

        System.out.println("stopWatch.shortSummary() = " + stopWatch.shortSummary());

    }
}
