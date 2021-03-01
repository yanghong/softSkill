package com.hunter.others;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/1 16:58
 */
public class TestWhile {

    static int num = 0;
    public static void main(String[] args) {
        new Thread(() ->{
            System.out.println("Child:" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
            System.out.println("Child End:" + num);
        }).start();
        System.out.println("Main11111->" + num);
        while(num == 0) {
            System.out.println("非常奇怪");
        }

        System.out.println("Main:" + num);
    }
}
