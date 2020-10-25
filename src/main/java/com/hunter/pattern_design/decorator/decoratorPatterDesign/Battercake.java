package com.hunter.pattern_design.decorator.decoratorPatterDesign;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 煎饼果子实体类
 * @date 2020/5/1 16:00
 */
public class Battercake extends AbstractBattercake {

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
