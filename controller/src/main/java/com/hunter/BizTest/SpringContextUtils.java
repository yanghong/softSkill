package com.hunter.BizTest;

import org.springframework.context.ApplicationContext;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 23:08
 */
public class SpringContextUtils {
    private static ApplicationContext applicationContext;

    public SpringContextUtils() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
