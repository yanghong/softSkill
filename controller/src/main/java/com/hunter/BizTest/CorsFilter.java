package com.hunter.BizTest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 23:11
 */
@Component
public class CorsFilter implements Filter {

    private static final Logger log = LogManager.getLogger(CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //默认域
        String origin = "http://yunying.beibei.com";
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String refer = httpServletRequest.getHeader("Referer");
        String originHeader = httpServletRequest.getHeader("Origin");
        if (StringUtils.isNotBlank(refer) && StringUtils.isNotBlank(originHeader)) {
            URL url = null;
            try {
                url = new URL(refer == null ? originHeader : refer);
            } catch (MalformedURLException e) {
                log.error("跨域处理有问题", e);
            }
            if (url != null) {
                String protocol = url.getProtocol();
                String host = url.getHost();
                if (StringUtils.isNotBlank(host) && host.contains("beibei.com")) {
                    origin = protocol + "://" + host;
                }
            }
        }

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // something init
    }

    @Override
    public void destroy() {
        // destroy something
    }


}
