package com.hunter.javaBase.string.JDKAndCGlib.CGtest;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 需要被代理的类，不需要实现顶层接口
 * @date 2020/12/10 20:16
 */
public class CglibTestSon {

    public CglibTestSon() {
    }
    public void gotoHome() {
        System.out.println("============gotoHome============");
    }
    public void gotoSchool() {
        System.out.println("===========gotoSchool============");
    }
    public void oneday() {
        gotoHome();
        gotoSchool();
    }
    public final void onedayFinal() {
        gotoHome();
        gotoSchool();
    }
}
