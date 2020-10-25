package com.hunter.pattern_design.rules.inversion;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 设计模式-未使用依赖倒置原则
 * @date 2020/5/21 21:03
 */
public class DependencyInversion {
    
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email{
    public String getInfo() {
        return "电子邮件信息： hello world";
    }
}

/**
 * // 完成Person接收消息的功能
 * // 方式1完成
 * // 1、简单，比较容易想到
 * // 2、如果我们获取的对象是微信、短信等，则新增类，同事Person也要增加相应的接收方法
 * // 3、解决思路：引入一个抽象的接口IReceiver, 表示接受者，这样Persion类与接口IReceiver发生依赖
 * // 因为Email、WeiXin等等属于接收的方位，他们各自实现IReceiver接口就ok，这样我们就符号依赖倒置原则
 */
class Person {
    public void receive(Email email) {
        System.out.printf(email.getInfo());
    }
}
