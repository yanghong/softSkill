package com.hunter.string.JDKAndCGlib.CGtest;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 可以类比于jdk动态代理中的InvocationHandler ，实
 * 际上被代理后重要的类，实际上后续执行的就是intercept里的方法，如果需
 * 要执行原来的方法，则调用 method.invoke(s, args);这里也加了一个aopMethod();
 * @date 2020/12/10 20:16
 */
public class MthdInvoker implements MethodInterceptor {

    private CglibTestSon s;

    public MthdInvoker(CglibTestSon s) {
        this.s = s;
    }
    private void aopMethod() {
        System.out.println("i am aopMethod");
    }
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        aopMethod();
        Object a = method.invoke(s, args);
        return a;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }
}
