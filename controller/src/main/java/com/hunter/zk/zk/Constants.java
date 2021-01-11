package com.hunter.zk.zk;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/7 13:08
 */
public class Constants {

    /**
     * zk相关
     */
    public static String zkPort = "2181";
    public static String zkHosts = "172.16.254.7";
    public static String zkHostAndPort = "172.16.254.7:2181";
    public static Integer zkSessionTimeoutMs = 20000;
    public static Integer zkConnectionTimeoutMs = 15000;
    public static Integer zkRetryMaxRetries = 20;
    public static Integer zkRetryBaseSleepTimeMs = 1000;
    public static Integer zkRetryMaxSleepTimeMs = 30000;
    public static String zkAuthUser;
    public static String zkAuthPassword;
    public static String zkPathNamespace = "simba_ant";
}
