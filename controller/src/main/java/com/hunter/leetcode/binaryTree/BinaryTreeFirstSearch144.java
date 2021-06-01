package com.hunter.leetcode.binaryTree;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 574 👎 0


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

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghong
 */
public class BinaryTreeFirstSearch144 {

    private static List<Integer> preorderList = new ArrayList<>();
    
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

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preOrder(root, preorderList);
        return preorderList;
    }

    public static List<Integer> preOrder(TreeNode root, List<Integer> res) {

        if (null == root) {
            return res;
        }

        res.add(root.val);

        if (null != root.left) {
            res = preOrder(root.left,res);
        }

        if (null != root.right) {
            res = preOrder(root.right, res);
        }

        return res;
    }

    public static void main(String[] args) {

        /**
         * //输入：root = [1,null,2]
         * //输出：[1,2]
         */
        TreeNode oneRight = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, null, oneRight);

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
        
    }
}
