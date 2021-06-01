package com.hunter.leetcode;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 515 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanghong
 */
public class BinaryTreeMinDepth111 {

    private static Set<Integer> hashset = new HashSet<>();

    private static Integer levelCount = Integer.MAX_VALUE;

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

    public static int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int count = 1;
        if (null != root.left) {
            levelSearch(root.left, count);
        }
        if (null != root.right) {
            levelSearch(root.right, count);
        }

        for (Integer i : hashset) {
            if (i <= levelCount) {
                levelCount = i;
            }
        }

        return levelCount;
    }

    private static int levelSearch(TreeNode root, int levelCount) {

        levelCount++;
        if (null != root.left) {
            levelCount = levelSearch(root.left, levelCount);
        }
        if (null != root.right) {
            levelCount = levelSearch(root.right, levelCount);
        }
        if (null == root.left && null == root.right) {
            hashset.add(levelCount);
        }

        return levelCount;

    }

    public static void main(String[] args) {

        /**
         * //输入：root = [3,9,20,null,null,15,7]
         * //输出：2
         */
//        TreeNode twoRight = new TreeNode(7, null, null);
//        TreeNode twoLeft = new TreeNode(15, null, null);
//        TreeNode oneRight = new TreeNode(20, twoLeft, twoRight);
//        TreeNode oneLeft = new TreeNode(9, null, null);


        /**
         * //输入：root = [2,null,3,null,4,null,5,null,6]
         * //输出：5
         */
        TreeNode fourRight = new TreeNode(6, null, null);
        TreeNode threeRight = new TreeNode(5, null, fourRight);
        TreeNode twoRight = new TreeNode(4, null, threeRight);
//        TreeNode twoLeft = new TreeNode(15, null, null);
        TreeNode oneRight = new TreeNode(3, null, twoRight);
//        TreeNode oneLeft = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(2, null, oneRight);

        System.out.println(minDepth(root));

    }
}
