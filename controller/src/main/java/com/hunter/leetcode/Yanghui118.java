package com.hunter.leetcode;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
// 👍 507 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghong
 */
public class Yanghui118 {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows < 0) {
            return null;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
           for (int j = 0; j <= i; j++) {
               if (i == 0) {
                   tmp.add(1);
               } else if (i == 1) {
                   tmp.add(1);
               } else {
                   // 获取上一层的数据
                   List<Integer> before = result.get(i - 1);
                   if (j == 0 || i == j) {
                       tmp.add(1);
                   } else {
                       tmp.add(before.get(j - 1) + before.get(j));
                   }
               }
           }
           result.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {

        int num = 5;
        System.out.println(generate(num));
    }
}
