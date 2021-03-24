package com.hunter.cron.cron4jplugin;

import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import it.sauronsoftware.cron4j.InvalidPatternException;
import it.sauronsoftware.cron4j.Scheduler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/8 11:43
 */
public class Cron4jPluginTask implements IPlugin {

    private Scheduler scheduler = null;
    private String config = "job.properties";
    private Properties properties;

    public void Cron4jPlugin(String config) {
        this.config = config;
    }

    public void Cron4jPlugin() {

    }

    @Override
    @SuppressWarnings({ "rawtypes"})
    public boolean start() {
        scheduler = new Scheduler();
        loadProperties();
        Enumeration enums = properties.keys();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement() + "";
            if (!key.endsWith("job")) {
                continue;
            }
            String cronKey = key.substring(0, key.indexOf("job")) + "cron";
            String enable = key.substring(0, key.indexOf("job")) + "enable";
            if (isDisableJob(enable)) {
                continue;
            }
            String jobClassName = properties.get(key) + "";
            String jobCronExp = properties.getProperty(cronKey) + "";
            Class clazz;
            try {
                clazz = Class.forName(jobClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {

                scheduler.schedule(jobCronExp, (Runnable) clazz.newInstance());
            } catch (InvalidPatternException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            scheduler.start();
            System.out.println(jobCronExp + " has been scheduled to run at: " + new Date()
                    + " and repeat based on expression: "
            );
        }
        return true;
    }

    private boolean isDisableJob(String enable) {
        return Boolean.valueOf(properties.get(enable) + "") == false;
    }

    private void loadProperties() {
        properties = new Properties();
        InputStream is = Cron4jPlugin.class.getClassLoader()
                .getResourceAsStream(config);
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean stop() {
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Cron4jPlugin plugin = new Cron4jPlugin();
        plugin.start();
        System.out.println("执行成功！！！");
        Thread.sleep(5000);
        // plugin.stop();
    }

}
