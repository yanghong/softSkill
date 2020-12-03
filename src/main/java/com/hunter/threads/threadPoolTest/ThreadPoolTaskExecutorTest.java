package com.hunter.threads.threadPoolTest;

import com.google.common.collect.Lists;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/2 23:41
 */
public class ThreadPoolTaskExecutorTest {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 核心线程数
        threadPool.setCorePoolSize(5);
        // 最大线程数
        threadPool.setMaxPoolSize(30);
        // 空闲线程存活时间
        threadPool.setKeepAliveSeconds(10);
        // 队列最大长度
        threadPool.setQueueCapacity(10);
        threadPool.initialize();

        List<String> paymentSeqNoList = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            paymentSeqNoList.add(String.valueOf(i));
        }

        Long startTime = System.currentTimeMillis();

        Map<String, FutureTask<String>> futureTaskMap = new HashMap<String, FutureTask<String>>();

        // 线程池提交返回
        for (String paymentSeqNo : paymentSeqNoList) {
            FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(paymentSeqNo);
                    return paymentSeqNo;
                }
            });
            futureTaskMap.put(paymentSeqNo, futureTask);

            // submit 提交执行
            threadPool.submit(futureTask);
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("耗时：" + (endTime - startTime));
    }
}
