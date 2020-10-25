package com.hunter.pattern_design.decorator.decoratorPatterDesign;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 香肠装饰类
 * @date 2020/5/1 16:30
 */
public class SausageDecorator extends AbstractDecorator{
    public SausageDecorator(AbstractBattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+" 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
