package com.hunter.pattern_design.singleton;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 静态内部类
 * @date 2020/12/11 9:38
 */
public class SingletonStaticInnerClass {


    private SingletonStaticInnerClass(){
    }
    public static SingletonStaticInnerClass getInstance(){
        return Inner.instance;
    }
    private static class Inner {
        private static final SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }
}
