package com.hunter.threads;

import java.util.concurrent.*;

/**
 * @author hunter.yang
 * @version 1.0
 * @description FutureTaskTest
 * @date 2020/12/3 12:34
 */
public class FutureTaskTest {

    private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName);

            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                // 1.2 创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);
                // 1.3
                future = taskCache.putIfAbsent(taskName, futureTask);

                if (future == null) {
                    future = futureTask;
                    // 1.4 执行任务
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }
    
    public static void main(String[] args) {



    }

}
