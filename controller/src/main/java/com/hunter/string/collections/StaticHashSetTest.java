package com.hunter.string.collections;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanghong
 */
public class StaticHashSetTest {

    private static Set<String> remainSet = Sets.newHashSet();

    public static void main(String[] args) {
        Set<String> source = new HashSet<>();
        source.add("1232");
        source.add("44535");
//        remainSet.addAll(source);

        dfs(source);

        System.out.println(JSON.toJSONString(remainSet));
    }

    private static void dfs(Set<String> target) {
        remainSet.addAll(target);
    }
}
