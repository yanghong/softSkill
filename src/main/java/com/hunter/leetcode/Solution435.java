package com.hunter.leetcode;

//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心算法

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/25 23:48
 */
public class Solution435 {

    public static int eraseOverlapIntervals(int[][] intervals) {

        int count = 0;

        if (intervals.length <= 0) {
            return count;
        }

        // 从小到大排序
        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));

        // 双端队列
        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i<intervals.length; ++i) {
            if (queue.isEmpty() || queue.peekLast()[1] <= intervals[i][0]) {
                queue.offerLast(intervals[i]);
            }

            if (!queue.isEmpty() && queue.peekLast()[1] > intervals[i][0] && queue.peekLast()[1] >intervals[i][1]) {
                queue.pollLast();
                queue.offerLast(intervals[i]);
            }

        }

        return intervals.length - queue.size();
    }

    public static void main(String[] args) {

        // [[1,100],[11,22],[1,11],[2,12]]

        int[][] arr = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(arr));

    }
}
