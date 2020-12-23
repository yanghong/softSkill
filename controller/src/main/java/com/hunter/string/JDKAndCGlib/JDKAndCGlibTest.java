package com.hunter.string.JDKAndCGlib;

import java.lang.reflect.Proxy;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/10 18:51
 */
public class JDKAndCGlibTest {

    public static void main(String[] args) {

        // JDK动态代理
        JavaProxyInterface javaProxyInterface = new ConcreteClass();

        JavaProxyInterface newJavaProxyInterface =
                (JavaProxyInterface) Proxy.newProxyInstance(
                JDKAndCGlibTest.class.getClassLoader(), new Class[] { JavaProxyInterface.class },
                new MyInvocationHandler<>(javaProxyInterface));

        // 这里可以看到这个类以及被代理，在执行方法前会执行 aopMethod（）。这里需要注意的是oneDay（）
        // 方法和 oneDayFinal（）的区别。oneDayFinal的方法aopMethod执行1次，oneDay的aopMethod执行1次
        newJavaProxyInterface.gotoSchool();
        newJavaProxyInterface.gotoWork();
        newJavaProxyInterface.oneDayFinal();
        newJavaProxyInterface.oneDay();

        // -----------------------------------------------------------------

    }
}
