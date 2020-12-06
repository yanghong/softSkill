package com.hunter.threads.threadPoolTest;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 线程池
 * @date 2020/12/2 23:41
 */
public class ThreadPoolTaskExecutorTest {

    /**
     * 使用阿里巴巴框架创建线程池
     * 
     * 1、ArrayBlockingQueue
     * 是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
     * 2、LinkedBlockingQueue
     * 一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列
     * 3、SynchronousQueue
     * 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool（5）使用了这个队列。
     * 4、PriorityBlockingQueue
     * 一个具有优先级的无限阻塞队列。
     */
    private static final ExecutorService THREAD_POOL = TtlExecutors.getTtlExecutorService(
            new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS,
                    new SynchronousQueue<>(),
                    new ThreadFactoryBuilder().setNameFormat("ThreadPoolTaskExecutorTest").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy()));

    /**
     * newFixedThreadPool()	线程数量固定的线程池
     * newCachedThreadPool()	可缓存线程的线程池
     * newScheduledThreadPool()	执行定时任务的线程池
     * newSingleThreadExecutor()	单线程线程池
     * @param args
     */
    public static void main(String[] args) {

        /**
         * corePoolSize - 线程池核心线程的数量。 （长期维持的数量）
         * maximumPoolSize - 线程池的最大线程数。
         * keepAliveTime - 当线程数大于核心时，一旦超过此时间，会将多余的空闲线程杀掉
         * unit - keepAliveTime 的时间单位。
         * workQueue - 用来储存等待执行任务的队列。
         * threadFactory - 线程工厂。
         * handler - 拒绝策略。可以选择指定的，也可以自定义拒绝策略，实现接口即可
         */
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 核心线程数
        threadPool.setCorePoolSize(5);
        // 最大线程数
        threadPool.setMaxPoolSize(30);
        // 空闲线程存活时间
        threadPool.setKeepAliveSeconds(10);
        // 队列最大长度
        threadPool.setQueueCapacity(10);
        threadPool.initialize();

        /**
         * AbortPolicy() 直接抛出拒绝异常
         * CallerRunsPolicy 如果线程池未关闭，则会在调用者线程中执行新任务，这回导致主线程提交线程性能变慢。
         * DiscardPolicy 不处理新任务，即丢弃。
         * DiscardOldestPolicy 抛弃最老的任务，就是从队列取出最老的任务然后放入新的任务进行执行。
         */
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        List<String> paymentSeqNoList = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            paymentSeqNoList.add(String.valueOf(i));
        }

        Long startTime = System.currentTimeMillis();

        Map<String, FutureTask<String>> futureTaskMap = new HashMap<String, FutureTask<String>>();

        // 线程池提交返回
        for (String paymentSeqNo : paymentSeqNoList) {
            FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(paymentSeqNo);
                    return paymentSeqNo;
                }
            });
            futureTaskMap.put(paymentSeqNo, futureTask);

            // submit 提交执行
            threadPool.submit(futureTask);
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("耗时：" + (endTime - startTime));
    }
}
