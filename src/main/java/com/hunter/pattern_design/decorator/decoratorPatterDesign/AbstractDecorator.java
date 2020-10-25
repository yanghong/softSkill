package com.hunter.pattern_design.decorator.decoratorPatterDesign;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 装饰类抽象
 * @date 2020/5/1 16:06
 */
public class AbstractDecorator extends AbstractBattercake {

    private AbstractBattercake abstractBattercake;

    public AbstractDecorator (AbstractBattercake abstractBattercake) {
        this.abstractBattercake = abstractBattercake;
    }

    @Override
    protected String getDesc() {
        return this.abstractBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return this.abstractBattercake.cost();
    }
}
