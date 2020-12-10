package com.hunter.javaBase.string.JDKAndCGlib;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/10 18:52
 */
public class ConcreteClass implements JavaProxyInterface {

    @Override
    public void gotoSchool() {
        System.out.println("gotoSchool");
    }

    @Override
    public void gotoWork() {
        System.out.println("gotoWork");
    }

    @Override
    public void oneDay() {
        gotoSchool();
        gotoWork();
    }

    @Override
    public void oneDayFinal() {
        gotoSchool();
        gotoWork();
    }
}
