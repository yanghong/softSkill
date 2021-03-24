package com.hunter.cron.ScheduledExcecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/8 14:02
 */
public class test {
    public void test() {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Hello !!");
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }
}
