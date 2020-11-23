package com.hunter.others;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;



/**
 * @description: TypeReferenceTest
 * @author: hunter.yang
 * @date: 20201119 20:26
 */
public class TypeReferenceTest {

    public static void main(String[] args) {
        Map<Long, Long> testMap = new HashMap<>();

        testMap.put(11111L, 444444L);
        testMap.put(11112L, 444444L);
        testMap.put(11113L, 444444L);
        testMap.put(11114L, 444444L);

        System.out.println(JSON.toJSONString(testMap));
    }

}
