package com.hunter.BizTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/14 17:59
 */
public class Test {

    public static void main(String[] args) {
        String jobInfo = "dwd_";
        String baifenhao = "%";
        jobInfo =  String.format("'%s'", jobInfo.replace(",", "|"));
        jobInfo = jobInfo + '%';
        System.out.println(jobInfo.replace("'%", "%'"));

        Set<Long> testSet = new HashSet();

        System.out.println(testSet.contains(1L));
    }
}
