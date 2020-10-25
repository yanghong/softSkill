package com.hunter.pattern_design.decorator;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/5/1 15:51
 */
public class DecoratorV1Test {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc() + "销售价格： " + battercake.cost());

        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc() + "销售价格： " + battercakeWithEgg.cost());

        Battercake battercakeWithSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithSausage.getDesc() + "销售价格： " + battercakeWithSausage.cost());
    }
}
