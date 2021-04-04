package com.hunter.leetcode.binaryTree;

//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下： 
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 树 
// 👍 263 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class MaxBinaryTree654 {
    
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
       }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        // 1 <= nums.length <= 1000 
        // 0 <= nums[i] <= 1000 
        // nums 中的所有整数 互不相同
        if (nums.length > 1000 || nums.length == 0) {
            return null;
        }
        
        int maxIndex = findMax(nums);
        TreeNode node = new TreeNode(nums[maxIndex]);
        if (maxIndex == 0) {
            node.left = null;
        } else {
            int[] result = splitNums(nums, 0, maxIndex-1);
            node.left = constructMaximumBinaryTree(result);
        }

        if (maxIndex == nums.length) {
            node.right = null;
        } else {
            int[] nextResult = splitNums(nums, maxIndex+1, nums.length-1);
            node.right = constructMaximumBinaryTree(nextResult);
        }

        return node;
    }
    
    private static int[] splitNums(int[] nums, int start, int end) {

        if (start < 0 || end < 0) {
            return null;
        }

        int[] result = new int[end - start + 1];

        if (end - start >= 0) {
            System.arraycopy(nums, start, result, 0, end - start + 1);
        }
        
        return result;
    }

    private static int findMax(int[] nums) {
        int max = -Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i< nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(nums);
        System.out.println(node);
        
    }
}
