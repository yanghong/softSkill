package com.hunter.threads;

/**
 * @author hunter.yang
 * @version 1.0
 * @description yield 测试
 * Thread.yield() 方法，使当前线程由执行状态，变成为就绪状态，让出cpu时间，
 * 在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行。
 *
 * @date 2020/12/10 20:26
 */
public class YieldTest extends Thread{

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yt1 = new YieldTest("张三");
        YieldTest yt2 = new YieldTest("李四");
        yt1.start();
        yt2.start();
    }
}
