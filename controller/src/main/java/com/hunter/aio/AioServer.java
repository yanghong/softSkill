package com.hunter.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hunter.yang
 * @version 1.0
 * @description AIO服务端
 * @date 2021/1/5 12:31
 */
public class AioServer {

    private final int port;

    public AioServer(int port) {
        this.port = port;
        listen();
    }

    public static void main(String[] args) {
        int port = 8000;
    }

    private void listen() {
//        try {
//            ExecutorService executorService = Executors.newCachedThreadPool();
//            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
//            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(threadGroup);
//            server.bind(new InetSocketAddress(port));
//            System.out.println("服务已启动，监听端口" + port);
//
//            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
//                final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
//
//                @Override
//                public void completed(AsynchronousSocketChannel result, Object attachment) {
//                    System.out.println("I/O 操作成功，开始获取数据");
//                }
//            })
//
//        }
    }

}
