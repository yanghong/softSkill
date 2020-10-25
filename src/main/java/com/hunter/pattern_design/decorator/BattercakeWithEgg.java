package com.hunter.pattern_design.decorator;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/5/1 15:50
 */
public class BattercakeWithEgg extends Battercake {

    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
