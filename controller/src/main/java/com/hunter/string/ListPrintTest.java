package com.hunter.string;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListPrintTest {

    public static void main(String[] args) {

        List<String[]> list = new ArrayList<>();

        String execId = "12212";
        String taskName = "taskName";
        String initTime = "2021-04-01 11:11:11";
        String ctUser = "hunter.yang";
        list.add(new String[]{execId, taskName, initTime, ctUser});

        System.out.printf(JSON.toJSONString(list));
    }
}
