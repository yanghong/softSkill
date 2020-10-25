package com.hunter.pattern_design.singleton;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 懒汉模式，线程不安全
 * @date 2020/8/23 6:58
 */
public class Singleton {
    private static Singleton instance;

    /**
     * 所有单例的构造器都要被设置为私有
     */
    private Singleton(){}

    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
