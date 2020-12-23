package com.hunter.intercept;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author hunter.yang
 * @version 1.0
 * @description DegradeAspect
 * @date 2020/12/16 11:24
 */
@Component
@Aspect
@Slf4j
public class DegradeAspect {

    @Around(value = "@annotation(com.hunter.intercept.DegradeAnnotation)")
    public Object process(ProceedingJoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DegradeAnnotation annotation = method.getAnnotation(DegradeAnnotation.class);

        int level = annotation.level();
//        if (level == DegradeLevelConstants.LEVEL_1) {
//            //如果等级为1，那么需要先去取 DEGRADE_LEVEL1_SWITCH
//            boolean level1Switch = BconfClient.isSwitchOn(BconfConstants.DEGRADE_LEVEL1_SWITCH, false);
//            if (level1Switch) {
//                return null;
//            }
//        }

        //如果hconf中配置的level>=方法注解中的level，则直接降级
//        String confValue = BconfClient.getConfValue(BconfConstants.DEGRADE_LEVEL_CONF, "-1");
//        if (StringUtils.isNumeric(confValue)) {
//            int confLevel = Integer.parseInt(confValue);
//            if (confLevel >= level) {
//                return null;
//            }
//        }
        //否则，根据方法别名去配置中获取是否存在此方法的单点降级，如果存在则直接降级
        String alias = annotation.alias();
//        String aliasConf = BconfClient.getConfValue(BconfConstants.DEGRADE_METHOD_ALIAS_CONF);
//        if (StringUtils.isNotBlank(aliasConf) && StringUtils.isNotBlank(alias)) {
//            String[] aliasArray = aliasConf.split(",");
//            boolean contains = ArrayUtils.contains(aliasArray, alias);
//            if (contains) {
//                return null;
//            }
//        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("调用外部方法出错，方法名{}", method.getName(), throwable);
            return null;
        }

    }

}
