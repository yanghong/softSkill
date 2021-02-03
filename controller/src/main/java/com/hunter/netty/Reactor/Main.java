package com.hunter.netty.Reactor;

import java.io.IOException;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/21 20:18
 */
public class Main {
    public static void main(String[] args) {
        try {
            TCPReactor reactor = new TCPReactor(1333);
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
