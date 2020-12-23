package com.hunter.leetcode;

import java.util.Arrays;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/25 15:35
 */
public class Solution455 {
    
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int child = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (child < g.length && res < s.length) {
            if (g[child] <= s[res]) {
                ++child;
            }
            ++res;
        }
        return child;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution455().findContentChildren(new int[]{1,2,3},new int[]{1,1}));
    }

}
