package com.hunter.leetcode;

//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
//，不能则返回False。
//
// 示例 1:
//
//
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
//
//
// 示例 2:
//
//
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
//
//
// 注意:
//
//
// 数组内已种好的花不会违反种植规则。
// 输入的数组长度范围为 [1, 20000]。
// n 是非负整数，且不会超过输入数组的大小。
//
// Related Topics 数组

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201026 20:03
 */
public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length<3) {
            return false;
        }

        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        boolean firstFlag = true;

        for (int i = 0; i< flowerbed.length; ++i) {
            if(deque.size() < 3) {
                deque.offerLast(flowerbed[i]);
            } else {

                if(deque.size() == 3 && deque.peekFirst() == 0 && firstFlag) {
                    deque.pollFirst();
                    if (deque.peekFirst() == 0) {
                        count++;
                    }
                    firstFlag = false;
                    continue;
                }

                if (deque.peekFirst() == 0 && deque.peekLast() == 0) {
                    deque.pollFirst();
                    if (deque.peekFirst() == 0) {
                        count++;
                        deque.pollFirst();
                        deque.offerFirst(1);
                    } else {
                        deque.pollFirst();
                    }
                    deque.offerLast(flowerbed[i]);
                } else {
                    deque.pollFirst();
                    deque.offerLast(flowerbed[i]);
                }

            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0}, 1));
    }

}
