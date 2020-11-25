package com.hunter.threads;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

/**
 * @description: 线程常用方法
 * @author: hunter.yang
 * @date: 20201125 13:33
 */
public class ThreadNormalFunctionTest {

    // https://www.cnblogs.com/HelloBigTable/p/10827269.html

//        // Thread.MIN_PRORITY
//
//        // isAlive()
//
//        // yield()
//
//        // join()
//
//        // interrupt()


    public static void main(String[] args) {
        System.out.println("当前线程位：" + Thread.currentThread().getName() + "，优先级为：" + Thread.currentThread().getPriority());
        PriorityDemo thread1 = new PriorityDemo("thread1");
        PriorityDemo thread2 = new PriorityDemo("thread2");
        PriorityDemo thread3 = new PriorityDemo("thread3");
        thread1.setPriority(MIN_PRIORITY);
        thread3.setPriority(MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
