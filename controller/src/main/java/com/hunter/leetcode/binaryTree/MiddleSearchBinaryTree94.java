package com.hunter.leetcode.binaryTree;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 示例 1：
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
// 示例 2：
//
//输入：root = []
//输出：[]
//
// 示例 3：
//
//输入：root = [1]
//输出：[1]
//
// 示例 4：
//
//输入：root = [1,2]
//输出：[2,1]
//
// 示例 5：
//
//输入：root = [1,null,2]
//输出：[1,2]
//
// 提示：
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 964 👎 0

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

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghong
 */
public class MiddleSearchBinaryTree94 {

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

     public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        solution(result, root);

        return result;
     }

     private static void solution(List<Integer> result, TreeNode root) {
         if (null == root) {
             return;
         }

         if (null != root.left) {
             solution(result, root.left);
         }

         result.add(root.val);

         if (null != root.right) {
             solution(result, root.right);
         }
     }

    public static void main(String[] args) {

        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode root = new TreeNode(1, null, two);

        System.out.println(inorderTraversal(root));
    }
}
