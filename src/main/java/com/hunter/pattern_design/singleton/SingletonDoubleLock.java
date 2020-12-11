package com.hunter.pattern_design.singleton;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 双重锁模式
 * @date 2020/12/11 9:37
 */
public class SingletonDoubleLock {

    private volatile static SingletonDoubleLock singleton;
    private SingletonDoubleLock (){}
    public static SingletonDoubleLock getSingleton(){
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null ) {
                    singleton = new SingletonDoubleLock();
                }
            }
        }
        return singleton;
    }
}
