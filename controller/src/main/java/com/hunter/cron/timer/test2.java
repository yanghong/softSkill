package com.hunter.cron.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/8 14:01
 */
public class test2 {


    public void test2 () {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }
}
