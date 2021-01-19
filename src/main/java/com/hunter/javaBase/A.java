package com.hunter.javaBase;

public class A extends B {

    @Override
    public String toString() {
        return "A";
    }

    public static void main(String[] args) {
        A a = new A();
        a.say();

        A.AIn aa = a.new AIn();
        aa.bin();

    }

    class AIn extends BIn{

    }

}