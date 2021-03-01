package com.hunter.others;

import org.joda.time.DateTime;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/2/26 16:05
 */
public class TimeTest {

    public static void main(String[] args) {
        String dumpDate = DateTime.now().toString("yyyy-MM-dd");
        String yesterday = DateTime.now().minusDays(1).toString("yyyy-MM-dd");

        System.out.println(dumpDate);
        System.out.println(yesterday);
    }
}
