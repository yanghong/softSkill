package com.hunter.intercept;

import java.lang.annotation.*;

/**
 * @author hunter.yang
 * @version 1.0
 * @description 降级切面
 * @date 2020/12/16 11:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DegradeAnnotation {

    /**
     * 降级等级 等级越高越重要
     *
     * @return
     */
    int level();

    /**
     * 方法别名，用于配置搭配hconf中的，一般命名规则可以是className_methodName 如果存在重载方法，则在后面加编号即可
     * 原则：绝不能重复，一旦有重复，可能导致降了不该降级的接口
     *
     * @return
     */
    String alias();
}
