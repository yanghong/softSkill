package com.hunter.javaBase.string.collections;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author hunter.yang
 * @version 1.0
 * @description use guava
 * @date 2020/12/15 11:36
 */
public class newHashMapTest {

    public static void main(String[] args) {
        Map<Long, String> map = Maps.newHashMap();
        map.put(1111L, "12312");
        System.out.println(map);
    }
}
