package com.hunter.lock.lock;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 测试公平锁和非公平锁
 * @date 2020/12/12 14:04
 */
public class FairAndUnfairTest {

    private static final ExecutorService THREAD_POOL = TtlExecutors.getTtlExecutorService(
            new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS,
                    new SynchronousQueue<>(),
                    new ThreadFactoryBuilder().setNameFormat("ThreadPoolTaskExecutorTest").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy()));

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    public static void fair() {
        testLock(fairLock);
    }

    public static void unfair() {
        testLock(unfairLock);
    }

    private static void testLock(ReentrantLock2 lock) {
        // 启动 5个job
        System.out.println("启动5个job\n");

        for (int i = 0; i < 50; i++) {
            int finalI = i;
            THREAD_POOL.execute(new Runnable() {
                @Override
                public void run() {
                    Job job;
                    if (finalI % 2 == 0) {
                        job = new Job(fairLock);
                    } else {
                        job = new Job(unfairLock);
                    }
                    job.start();
                }
            });
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job (ReentrantLock2 lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 连续打印当前的Thread和等待队列中的Thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 等待中的线程：" + lock.getQueueThreads());
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueueThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public static void main(String[] args) {
//        fair();

        unfair();
    }

}
