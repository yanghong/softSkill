package com.hunter.string;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description String 去除重复数据，保留第一次出现的
 * @date 2020/12/23 14:07
 */
public class RemoveRepeatTest {
    
    public static void main(String[] args) {

        String str = "vip0升级符合条件，奖励待入账;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0;奖励失效，用户降级为V0";

        String[] strList = str.split(";");

        Set<String> strSet = Sets.newHashSet(strList);

        StringBuilder result = new StringBuilder();

        for (String s : strSet) {
            result.append(s).append(";");
        }
        result.toString().substring(0, result.length() - 1);
        System.out.println(result.toString().substring(0, result.length() - 1));

    }

    public static String removeRepeat(String str) {

        StringBuffer sb = new StringBuffer(str);

        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");

        StringBuffer out = new StringBuffer(rs);

        return out.reverse().toString();
    }
}
