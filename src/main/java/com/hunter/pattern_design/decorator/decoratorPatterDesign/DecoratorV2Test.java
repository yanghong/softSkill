package com.hunter.pattern_design.decorator.decoratorPatterDesign;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 测试类
 * @date 2020/5/1 16:31
 */
public class DecoratorV2Test {

    public static void main(String[] args) {
        AbstractBattercake abstractBattercake;
        abstractBattercake = new Battercake();
        abstractBattercake = new EggDecorator(abstractBattercake);
        abstractBattercake = new SausageDecorator(abstractBattercake);

        System.out.println(abstractBattercake.getDesc() + " 销售价格 ： " + abstractBattercake.cost());
    }
}
