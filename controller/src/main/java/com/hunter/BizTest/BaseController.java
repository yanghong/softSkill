package com.hunter.BizTest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 23:04
 */
public class BaseController {

    /**
     * 统一返回结果
     *
     * @param o
     * @return
     */
    public Result getResult(Object o) {

        return new Result(o);
    }

    /**
     * 获取response
     * <p>
     * 直接写在Controller参数中LoggerAspect会报错，因此写了此函数
     */
    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取request
     * <p>
     * 直接写在Controller参数中LoggerAspect会报错，因此写了此函数
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
