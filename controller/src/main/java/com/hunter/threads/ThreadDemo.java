package com.hunter.threads;

import static java.lang.Thread.sleep;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/7 13:05
 */
public class ThreadDemo {

    private static Boolean running = true;

    public static void main(String[] args) throws InterruptedException{

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {

                }
            }
        }).start();

        Thread.sleep(10);

        running = false;

    }
}
