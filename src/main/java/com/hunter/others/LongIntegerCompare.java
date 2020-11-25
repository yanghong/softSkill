package com.hunter.others;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201123 16:34
 */
public class LongIntegerCompare {

    public static void main(String[] args) {
//        Integer a = 11111;
//        Long b = 11111L;
//
//        System.out.println(Long.valueOf(a).equals(b));
//        System.out.println(a.longValue());


        String conf = "{1231:2223}";

        Map<Long, Long> idMap = JSON.parseObject(conf, new TypeReference<Map<Long, Long>>(){});

        System.out.println(idMap);
    }

}
