package com.hunter.leetcode.binaryTree;

//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树


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

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/30 18:59
 */
public class ReserveBinaryTree226 {

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

    public static TreeNode invertTree(TreeNode root) {

        if (null == root) {
            return null;
        }

        reserve(root);

        return root;

    }

    public static void reserve(TreeNode root) {

        TreeNode tmpNode;

        tmpNode = root.right;
        root.right = root.left;
        root.left = tmpNode;

        if (null != root.left) {
            reserve(root.left);
        }

        if (null != root.right) {
            reserve(root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode4 = new TreeNode(1, null, null);
        TreeNode treeNode5 = new TreeNode(3, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(9, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(7, treeNode6, treeNode7);
        TreeNode treeNode1 = new TreeNode(4, treeNode2, treeNode3);

        TreeNode result = invertTree(treeNode1);

    }

}
