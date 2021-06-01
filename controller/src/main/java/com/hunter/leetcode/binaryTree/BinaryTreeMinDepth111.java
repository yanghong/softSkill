package com.hunter.leetcode.binaryTree;

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

/**
 * @author yanghong
 */
public class BinaryTreeMinDepth111 {

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
        if (root.right == null && root.left == null) {
            return 1;
        }

        int minDep = Integer.MAX_VALUE;
        if (null != root.left) {
            minDep = minDepth(root.left);
        }
        if (null != root.right) {
            minDep = minDepth(root.right);
        }

        return minDep + 1;
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
