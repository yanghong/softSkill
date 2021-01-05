package com.hunter.controller;

import com.hunter.BizTest.CorsFilter;
import com.hunter.BizTest.MaterialController;
import com.hunter.BizTest.SpringContextUtils;
import com.hunter.BizTest.SystemPropertyConfig;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@EnableWebMvc
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);

        try {
            SpringApplication application = new SpringApplication(Application.class);
            application.addListeners(new ApplicationPidFileWriter());
            application.addListeners(new SystemPropertyConfig());
            ConfigurableApplicationContext applicationContext = application.run(args);
            SpringContextUtils.setApplicationContext(applicationContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new CorsFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}
