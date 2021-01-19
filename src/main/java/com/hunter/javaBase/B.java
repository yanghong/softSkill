package com.hunter.javaBase;

public class B {
    public Thread thread;

    public void say() {
        // 输出A
        System.out.println(this.toString());
        // 输入A，父类方法中使用真正子类对象用"父类.this"
        System.out.println(B.this.toString());

        say1(new I() {
            @Override
            public void II() {//匿名内部类的this
                System.out.println(this);//B$1
                System.out.println(B.this);//A
//                System.out.println(A.this);  父类是访问不到子类A的,只能写B.    不能写B.A的属性，只能写B.B的属性，也就是给子类A对象赋值，因为访问不到A的任何东西
                thread = Thread.currentThread();
                B.this.thread = Thread.currentThread();
            }
        });
    }

    @Override
    public String toString() {
        return "B";
    }

    public void say1(I i) {
        i.II();
    }

    class BIn{
        public void bin() {
            B.this.thread = Thread.currentThread();
//            A.this.thread = Thread.currentThread();   父类是访问不到子类A的,只能写B.
            System.out.println(B.this);//A
        }
    }

}