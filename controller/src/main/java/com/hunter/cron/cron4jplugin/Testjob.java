package com.hunter.cron.cron4jplugin;

import java.util.Date;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/8 14:09
 */
public class Testjob implements Runnable {

    @Override
    public void run() {
        System.out.println("Current system time: " + new Date());
        System.out.println("Another minute ticked away...");
    }
}
