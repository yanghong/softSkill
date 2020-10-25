package com.hunter.pattern_design.rules.inversion;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 依赖关系传递方式
 * @date 2020/5/21 21:21
 */
public class DeliveryWays {
    public static void main(String[] args) {

    }
}

/**
 * 方式1：通过接口传递实现依赖
 * 开关的接口
 */
interface IOpenAndClose {
    public void open(ITV itv); // 抽象方法，接收接口
}
interface ITV { // ITV接口
    public void play();
}
// 实现接口
class OpenAndClose implements IOpenAndClose {
    @Override
    public void open(ITV itv) {
        itv.play();
    }
}

/**
 * 方式2：通过构造方法依赖传递
 */
interface IOpenAndClose2 {
    public void open(); // 抽象方法
}
interface ITV2 { // ITV接口
    public void play();
}
class OpenAndClose2 implements IOpenAndClose2 {
    public ITV2 itv; // 成员

    public OpenAndClose2(ITV2 itv) { // 构造器
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}

/**
 * 方式3，通过setter方法传递
 */
interface IOpenAndClose3 {
    public void open(); // 抽象方法

    public void setTv(ITV3 itv3);
}
interface ITV3 { // ITV接口
    public void play();
}
class OpenAndClose3 implements IOpenAndClose3 {
    public ITV3 itv; // 成员

    @Override
    public void open() {
        this.itv.play();
    }

    @Override
    public void setTv(ITV3 itv3) {
        this.itv = itv;
    }
}