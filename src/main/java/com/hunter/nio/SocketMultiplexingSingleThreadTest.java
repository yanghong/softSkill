package com.hunter.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 多路复用
 * @date 2020/12/6 18:36
 */
public class SocketMultiplexingSingleThreadTest {

    private ServerSocketChannel server = null;

    /**
     * linux 多路复用器 （select poll epoll kqueue） nginx event()
     */
    private Selector selector = null;

    int port = 9090;

    public void initServer() {
        try {

            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            // 如果在epoll模型下， open -->> epoll create --> fd3
            selector = Selector.open(); // select poll * epoll 优先选择：epoll 但是可以 -D 修正

            // server 约等于listen 状态的fd4
            /**
             * register
             * 如果：
             * select .poll jvm 里开辟一个数组fd4 放进去
             * epoll : epoll_ctl （fd3, ADD, fd4, EPOLLIN）
             */
            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务器启动了。。。。。");

        try {
            while (true) { // 死循环

                Set<SelectionKey> keys = selector.keys();
                System.out.println(keys.size() + " size");

                // 1、调用多路复用器（select poll or epoll (epoll_wait)）
                /* 1.1 select() 是啥意思
                    // select poll 其实 内核的select (fd4) poll(fd4)
                // epoll ：其实内核的epoll_wait()
                // 参数可以带时间：没有时间： 0 ： 阻塞，有时间设置一个超时
                selector.wakeup() 结果返回0

                懒加载：
                其实再触碰到selector.select() 调用的时候触发了epoll_ctl 的调用
                 */
                 while (selector.select() > 0) {
                     // 返回有状态的fd集合
                     Set<SelectionKey> selectionKeys = selector.selectedKeys();
                     Iterator<SelectionKey> iter = selectionKeys.iterator();

                     // NIO 自己对着每一个fd调用系统调用，浪费资源

                     while (iter.hasNext()) {
                         SelectionKey key = iter.next();
                         iter.remove();
                         if (key.isAcceptable()) {
                             //  看代码的时候，这里是重点，如何去接收一个新的链接
                             // 语义上，accept 接受连接且返回新连接的fd
                             // 那新的fd怎么把？
                             // select ,poll 因为他们内核没有空间。那么jvm中保存和前边的
                         }
                     }
                 }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
