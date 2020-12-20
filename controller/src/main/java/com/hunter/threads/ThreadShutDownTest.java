package com.hunter.threads;

import java.util.concurrent.TimeUnit;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 安全终止线程
 * @date 2020/12/20 22:56
 */
public class ThreadShutDownTest {

    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠1秒， main线程对CountThread进行中端，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();

        // 睡眠1秒，main线程对Runner two 进行取消，使CountThread能够感知on 为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {

        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {

            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
