package com.hunter.netty.Reactor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author hunter.yang
 * @version 1.0
 * @description bilibili netty 教程
 * @date 2021/1/21 20:12
 */
public class Acceptor implements Runnable{

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public Acceptor(Selector selector, ServerSocketChannel ssc) {
        // 服务器的socket
        this.ssc = ssc;
        this.selector = selector;
    }

    @Override
    public void run() {

        try {
            SocketChannel sc = ssc.accept();

            System.out.println(sc.socket().getRemoteSocketAddress().toString() + "is connected");
            if (sc != null) {
                sc.configureBlocking(false);
                SelectionKey sk = sc.register(selector, SelectionKey.OP_READ);
                selector.wakeup();
//                sk.attach(new TCPHandler(sk, sc));
            }

        } catch (Exception e) {
            System.out.println("error: {}" + e.getMessage());
        }

    }
}
