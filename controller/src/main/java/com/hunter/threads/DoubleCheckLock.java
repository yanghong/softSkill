package com.hunter.threads;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/22 23:36
 */
public class DoubleCheckLock {

    private static boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            System.out.println("waitint data .....");
            while (!initFlag) {

            }
            System.out.println("===========success");
        }).start();

        Thread.sleep(2000);

        new Thread(() ->prepareData()).start();
    }

    public static void prepareData() {
        System.out.println("prepare data .....");
        initFlag = true;
        System.out.println("prepare data end.....");
    }
}
