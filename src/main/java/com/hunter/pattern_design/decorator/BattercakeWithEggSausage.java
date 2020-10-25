package com.hunter.pattern_design.decorator;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/5/1 15:51
 */
public class BattercakeWithEggSausage extends BattercakeWithEgg {

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
