package com.hunter.others;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201123 16:34
 */
public class LongIntegerCompare {

    public static void main(String[] args) {
        Integer a = 11111;
        Long b = 11111L;

        System.out.println(Long.valueOf(a).equals(b));
        System.out.println(a.longValue());
    }

}
