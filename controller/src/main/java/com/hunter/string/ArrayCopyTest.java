package com.hunter.string;

public class ArrayCopyTest {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = new int[2];
        System.arraycopy(nums, 0, result, 1, 2);
        System.out.println(result);
    }
}
