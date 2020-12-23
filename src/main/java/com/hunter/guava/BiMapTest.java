package com.hunter.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @description: BiMapTest
 * @author: hunter.yang
 * @date: 20201125 19:14
 */
public class BiMapTest {

    public static void main(String[] args) {
        //双向map
        BiMap<Integer,String> biMap= HashBiMap.create();
        biMap.put(1,"张三");
        biMap.put(2,"李四");
        biMap.put(3,"王五");
        biMap.put(4,"赵六");
        biMap.put(5,"李七");
        biMap.put(6,"赵六");

        //通过key值得到value值(注意key里面的类型根据泛行
        String value= biMap.get(1);
        System.out.println("id为1的value值 --"+value);

        //通过value值得到key值
        int key= biMap.inverse().get("赵六");
        System.out.println("赵六 --"+key);

        //通过key值重复，那么vakue值会被覆盖。
        String valuename= biMap.get(4);
        System.out.println("id为4的value值 --"+valuename);
    }

}
