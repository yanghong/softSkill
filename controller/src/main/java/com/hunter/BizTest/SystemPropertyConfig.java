package com.hunter.BizTest;

import com.google.common.base.Strings;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 23:15
 */
public class SystemPropertyConfig implements ApplicationListener, Ordered {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ConfigurableEnvironment environment = ((ApplicationEnvironmentPreparedEvent) event).getEnvironment();
            // metric env
//            System
//                    .setProperty("metric.application", Strings.nullToEmpty(environment.getProperty("metric.application")));
//            System.setProperty("metric.factory.type",
//                    Strings.nullToEmpty(environment.getProperty("metric.factory.type")));
//            // flume env
//            System.setProperty("logger.flume.agent.host",
//                    Strings.nullToEmpty(environment.getProperty("logger.flume.agent.host")));
//            System.setProperty("logger.flume.agent.port",
//                    Strings.nullToEmpty(environment.getProperty("logger.flume.agent.port")));
//            System.setProperty("logger.flume.agent.activate",
//                    Strings.nullToEmpty(environment.getProperty("logger.flume.agent.activate")));
//            System.setProperty("logger.flume.agent.sendBatchLogMode",
//                    Strings.nullToEmpty(environment.getProperty("logger.flume.agent.sendBatchLogMode")));
//            System.setProperty("logger.flume.agent.applicationName",
//                    Strings.nullToEmpty(environment.getProperty("logger.flume.agent.applicationName")));
            // datasource security env
            System.setProperty("appName",
                    Strings.nullToEmpty(environment.getProperty("spring.datasource.security.appName")));
//            System.setProperty("zkServer",
//                    Strings.nullToEmpty(environment.getProperty("spring.datasource.security.zkServer")));
        }
    }

    @Override
    public int getOrder() {
        return LoggingApplicationListener.DEFAULT_ORDER - 1;
    }
}
