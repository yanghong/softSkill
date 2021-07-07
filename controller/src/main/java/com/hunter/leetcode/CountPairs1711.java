package com.hunter.leetcode;
// 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
// 你可以搭配 任意 两道餐品做一顿大餐。
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 10^9 + 7 取余。
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
//
// 示例 1：
//
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
//
// 示例 2：
//
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
//
// 提示：
//
// 1 <= deliciousness.length <= 105
// 0 <= deliciousness[i] <= 220
//
// Related Topics 数组 哈希表
// 👍 72 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghong
 */
public class CountPairs1711 {

    public static int countPairs(int[] deliciousness) {

        int count = 0;

        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if (judge2me(deliciousness[i] + deliciousness[j])) {
                    count++;
                }
            }
        }

        return count % 1000000007;

    }

    /**
     * 判断是否是2的幂次
     */
    private static boolean judge2me(int a) {

        int count = 1;
        int tmp = a;
        int mod;

        if (a == 1) {
            return true;
        }

        while (a > 2) {
            mod = a/2;
            count++;
            a = mod;
        }

        return tmp == Math.pow(2.0, count);
    }

    public static int countPairsLeetcode(int[] deliciousness){
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {

        int[] pairs = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        int[] pairs_ = {2,4,8,16,32,64,128,256,512,1024,2048,4096};

        System.out.println(countPairs(pairs));


    }
}
