package com.hunter.leetcode;

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。
//
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？
//
// 示例 1:
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2:
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
// Related Topics 贪心算法

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/25 21:35
 */
public class Solution135 {

    public static int candy(int[] ratings) {
        int candyCount = 0;

        if (ratings.length<=0) {
            return candyCount;
        }

        int[] candyArray = new int[ratings.length];

        for (int i = 0; i< ratings.length-1; i++ ){
            if (ratings[i+1] > ratings[i] && candyArray[i+1] <= candyArray[i]) {
                candyArray[i+1] = candyArray[i] + 1;
            }
        }

        for (int j = ratings.length - 1; j>0; j--){
            if (ratings[j-1] > ratings[j] && candyArray[j-1] <= candyArray[j]) {
                candyArray[j-1] = candyArray[j] + 1;
            }
        }

        for (int i = 0; i< ratings.length; i++ ){
            candyCount = candyArray[i] + candyCount + 1;
        }

        return candyCount;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
    }

}
