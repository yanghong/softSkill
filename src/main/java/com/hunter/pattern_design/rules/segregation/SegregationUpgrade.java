package com.hunter.pattern_design.rules.segregation;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 设计模式-使用接口隔离原则
 * 客户端不应该依赖它不需要的接口，即一个类对另一个类的历来应该建立在最小的接口上。
 * @date 2020/5/21 20:45
 */
public class SegregationUpgrade {
    
    public static void main(String[] args) {
        // 使用
        AA a = new AA();
        a.depend1(new BB()); // AA 类通过接口去依赖BB类
        a.depend2(new BB());
        a.depend3(new BB());

        CC c = new CC();
        c.depend1(new DD()); // CC 类通过接口去依赖DD类
        c.depend4(new DD());
        c.depend5(new DD());
    }
}

interface Interface1Upgrade {
    void operation1();
}

interface Interface2 {
    void operation2();
    void operation3();
}

interface Interface3 {
    void operation4();
    void operation5();
}

class BB implements Interface1Upgrade,Interface2 {
    @Override
    public void operation1(){
        System.out.println("B 实现了 operation1");
    }
    @Override
    public void operation2(){
        System.out.println("B 实现了 operation2");
    }
    @Override
    public void operation3(){
        System.out.println("B 实现了 operation3");
    }
}

class DD implements Interface1Upgrade,Interface3 {
    @Override
    public void operation1(){
        System.out.println("D 实现了 operation1");
    }
    @Override
    public void operation4(){
        System.out.println("D 实现了 operation4");
    }
    @Override
    public void operation5(){
        System.out.println("D 实现了 operation5");
    }
}

class AA { // A 类通过接口nterface1 依赖B类，但是只会用到1，2，3方法
    public void depend1(Interface1Upgrade i) {
        i.operation1();
    }
    public void depend2(Interface2 i) {
        i.operation2();
    }
    public void depend3(Interface2 i) {
        i.operation3();
    }
}

class CC { // C 类通过接口nterface1 依赖D类，但是只会用到1，4，5方法
    public void depend1(Interface1Upgrade i) {
        i.operation1();
    }
    public void depend4(Interface3 i) {
        i.operation4();
    }
    public void depend5(Interface3 i) {
        i.operation5();
    }
}

