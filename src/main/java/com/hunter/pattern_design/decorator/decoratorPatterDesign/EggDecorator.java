package com.hunter.pattern_design.decorator.decoratorPatterDesign;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 鸡蛋装饰类
 * @date 2020/5/1 16:26
 */
public class EggDecorator extends AbstractDecorator{

    public EggDecorator(AbstractBattercake abstractBattercake) {
        super(abstractBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
