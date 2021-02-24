package com.hunter.threads.muti_thread;


/**
 * @author hunter.yang
 * @version 1.0
 * @description 线程通信研究wait()和notify()
 * @date 2020/5/28 23:36
 */
public class Data {

    private String packet;

    /**
     *    True if receiver should wait
     *    False if sender should wait
     */
    private boolean transfer = true;

    public synchronized void send(String packet) {

        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" + e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" + e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}
