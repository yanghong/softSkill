package com.hunter.threads;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201125 13:40
 */
public class PriorityDemo extends Thread {
    public PriorityDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=1;i<4;i++){
            System.out.println(this.getName() + "循环了：" + i + "次");
        }
    }
}
