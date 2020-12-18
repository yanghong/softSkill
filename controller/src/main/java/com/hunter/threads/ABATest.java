package com.hunter.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/10 20:54
 */
public class ABATest {
    
    private static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
    
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(100, 101));
            System.out.println(atomicReference.compareAndSet(100, 102));
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(101, 2019) + "\t修改后的值：" + atomicReference.get());
        }, "t2").start();
    }
}
