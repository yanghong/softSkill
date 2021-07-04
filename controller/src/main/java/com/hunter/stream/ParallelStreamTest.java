package com.hunter.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/yy1098029419/article/details/89452380
 * @author yanghong
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<String> strs = numbers.stream().map(num -> Integer.toString(++num)).collect(Collectors.toList());

        numbers.parallelStream().forEach(num-> System.out.println(num));
    }
}
