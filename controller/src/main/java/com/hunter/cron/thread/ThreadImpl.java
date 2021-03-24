package com.hunter.cron.thread;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/8 14:00
 */
public class ThreadImpl {

    public static void test1() {
        // 单位: 毫秒
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // ------- code for task to run
                    System.out.println("Hello !!");
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        test1();
    }
}
