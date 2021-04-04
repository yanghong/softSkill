package com.hunter.leetcode.binaryTree;

//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树
// 👍 255 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.LinkedList;

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
 * @author yanghong
 */

public class FindDuplicateSubTree652 {

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

    static HashMap<String, Integer> memo = new HashMap<>();

    static LinkedList<TreeNode> res = new LinkedList<>();

    public static LinkedList<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return res;
    }

    private static String traverse(TreeNode root) {

        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);

        if (freq == 1) {
            res.add(root);
        }

        memo.put(subTree, freq + 1);
        return subTree;
    }

    public static void main(String[] args) {

//        TreeNode treeNode4 = new TreeNode(4, null, null);
//        TreeNode treeNode5 = new TreeNode(2, treeNode4, null);
//        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
//        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode4);
//        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        TreeNode treeNode2 = new TreeNode(1, null, null);
        TreeNode treeNode3 = new TreeNode(1, null, null);
        TreeNode treeNode1 = new TreeNode(2, treeNode2, treeNode3);

        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   2   4
        //       /
        //      4

        LinkedList<TreeNode> res = findDuplicateSubtrees(treeNode1);

        System.out.println(res);

    }
}
