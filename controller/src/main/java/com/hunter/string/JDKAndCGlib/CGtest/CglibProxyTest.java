package com.hunter.string.JDKAndCGlib.CGtest;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/10 20:16
 */
public class CglibProxyTest {

    public static void main(String[] args) throws Exception {
        CglibTestSon CglibTestSon = new CglibTestSon();
        Enhancer enhancer = new Enhancer();
        Callback s = (Callback) new MthdInvoker(CglibTestSon);
        enhancer.setSuperclass(CglibTestSon.class);
        Callback callbacks[] = new Callback[] { s };
        enhancer.setCallbacks(callbacks);
        CglibTestSon CglibTestSon2 = (CglibTestSon) enhancer.create();
        CglibTestSon2.gotoHome();
        CglibTestSon2.gotoSchool();
        // 这里可以看到这个类以及被代理，在执行方法前会执行aopMethod（）。这里需要注意的是oneDay（）方法和onedayFinal（）的区别。onedayFinal的方法aopMethod执行2次，oneDay的aopMethod执行1次 ,注意这里和jdk的代理的区别
        CglibTestSon2.oneday();
        CglibTestSon2.onedayFinal();
    }
}
