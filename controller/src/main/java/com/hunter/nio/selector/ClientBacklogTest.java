package com.hunter.nio.selector;

import java.io.IOException;
import java.net.Socket;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/11 22:48
 */
public class ClientBacklogTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            Socket socket = new Socket("localhost", 8888);
            socket.close();
            System.out.println("  客户端的连接个数为： " + (i + 1));
        }
    }
}
