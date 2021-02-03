package com.hunter.netty.Reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/21 20:09
 */
public class TCPReactor implements Runnable{

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public TCPReactor(int port) throws IOException {
        // 创建选择器对象
        selector = Selector.open();
        // 打开服务端socket
        ssc = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress(port);
        // 绑定端口
        ssc.socket().bind(addr);
        // 设置为非阻塞
        ssc.configureBlocking(false);
        SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 给定key一个附加的Acceptor对象
        sk.attach(new Acceptor(selector, ssc));
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Waiting for new event on port:" + ssc.socket().getLocalPort() + ".....");
            try {
                // 查看是否有事件发生 有事件发生则把这个事件加入到selectorKeys
                // 若没有事件则发生阻塞
                if (selector.select() == 0) {
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("aaaaaaaaaa");

            // 能够执行到这里，说明发生了时间
            // 取的所有已就绪事件的key集合
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeySet.iterator();

            // 遍历已发生的事件
            while (it.hasNext()) {
                // read事件对象
                SelectionKey selectionKey = it.next();
                dispatch(selectionKey);
                it.remove();
            }
        }

    }

    private void dispatch(SelectionKey selectionKey) {
        // 取出附加对象 根据附加对象判断是什么事件 调用不同附加对象的run方法

        // new Acceptor(selector, ssc)
        Runnable r = (Runnable)(selectionKey.attachment());
        if (r != null) {
            r.run();
        }
    }


}
