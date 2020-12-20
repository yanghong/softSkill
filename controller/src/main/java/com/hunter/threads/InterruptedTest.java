package com.hunter.threads;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/20 22:43
 */
public class InterruptedTest {

    public static void main(String[] args) throws Exception {
        // sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        // busyThread 不停运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        // 休眠5s钟，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted id " + busyThread.isInterrupted());

        // 防止sleepThread 和 busyThread 立刻退出
        TimeUnit.SECONDS.sleep(2);

    }

    static class SleepRunner implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(10);
            }
        }
    }

}
