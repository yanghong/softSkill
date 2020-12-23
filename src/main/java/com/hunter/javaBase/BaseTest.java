package com.hunter.javaBase;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 给定一个乱序的数组，删除所有重复元素，
 * 使得每个元素只出现一次，
 * 并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/21 21:32
 */
public class BaseTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String line = in.next();

            String[] list = line.split(",");

            if (list.length > 100) {
                return;
            }

            Map<Integer, Integer> intMap = new LinkedHashMap<>();
            List<Integer> result = new LinkedList<>();
            int count = 0;

            for (String str : list) {
                Integer a = Integer.valueOf(str);

                if (a > 100) {
                    return;
                }

                if (intMap.size() <= 0) {
                    intMap.put(a, ++count);
                }else if (null == intMap.get(a)) {
                    intMap.put(a, ++count);
                } else if (null != intMap.get(a)) {
                    count = intMap.get(a) + 1;
                    intMap.put(a, count);
                }
                count = 0;
            }

            for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
                if (result.size() == 0) {
                    result.add(entry.getKey());
                } else {
                    int resultSize = result.size();
                    for (int i = 0; i < resultSize; i++) {
                        Integer temp = result.get(i);

                        if (null != intMap.get(temp)) {
                            Integer iCount = intMap.get(temp);
                            if (iCount < entry.getValue()) {
                                Integer resultTemp = result.get(i);
                                result.set(i, entry.getKey());
                                result.add(resultTemp);
                                continue;
                            }
                            if (iCount.equals(entry.getValue())) {
                                result.add(entry.getKey());
                            }
                            if (!result.contains(entry.getKey()) && i == resultSize -1) {
                                result.add(entry.getKey());
                            }
                        }
                    }
                }
            }

            List<Integer> resultOut = new LinkedList<>();

            for (Integer temp : result) {
                if (resultOut.contains(temp)) {
                    continue;
                }
                resultOut.add(temp);
            }

            System.out.println(resultOut.toString().replace("[", "").replace("]", "").replace(", ", ","));
        }
    }

}
