package com.hunter.string;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.StringJoiner;
import java.util.concurrent.*;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/6 22:38
 */
public class StringJoinTest {

    /**
     * 手动创建线程池
     */
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8,1, TimeUnit.SECONDS,
            new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 使用阿里巴巴框架创建线程池
     */
    private static final ExecutorService threadPool = TtlExecutors.getTtlExecutorService(
            new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS,
                    new SynchronousQueue<>(),
                    new ThreadFactoryBuilder().setNameFormat("ThreadPoolTaskExecutorTest").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy()));

    public static void main(String[] args) {

        String str = String.join("122", "好好", "world");
        System.out.println(str);

        StringJoiner stringJoiner = new StringJoiner(",", "[","]");
        stringJoiner.setEmptyValue("void");        stringJoiner.add("weijia");
        System.out.println(stringJoiner.toString());

        StringBuilder sb = new StringBuilder();
        sb.append("hahahah");
        System.out.println(sb);

        // 线程安全
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("i");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sb.append(" am");
                System.out.println(sb);
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                sb.append(" thread");
                System.out.println(sb);
            }
        });

        threadPoolExecutor.execute(thread);

        threadPoolExecutor.execute(threadTwo);

        stringBuffer.append(" safe");


        CompletableFuture<StringBuilder> stringBufferCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return sb.append(" sb a ");
        }, threadPool);

        stringBufferCompletableFuture.join();

        System.out.println(sb);
    }
}
