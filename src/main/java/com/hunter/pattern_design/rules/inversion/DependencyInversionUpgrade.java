package com.hunter.pattern_design.rules.inversion;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 设计模式-依赖倒置原则
 * @date 2020/5/21 21:11
 */
public class DependencyInversionUpgrade {

        public static void main(String[] args) {
            PersonUpgrade person = new PersonUpgrade();
            person.receive(new EmailUpgrade());
            person.receive(new WeiXin());
        }
    }

/**
 * 定义接口
 */
interface IReceiver{
    public String getInfo();
}

class EmailUpgrade implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮件信息： hello world\n";
    }
}

// 增加微信
class WeiXin implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息： hello world\n";
    }
}

/**
 * 方式2
 */
class PersonUpgrade {
    // 这里我们依赖的是接口
    public void receive(IReceiver iReceiver) {
        System.out.printf(iReceiver.getInfo());
    }
}
