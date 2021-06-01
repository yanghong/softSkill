package com.hunter.leetcode.binaryTree;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 595 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghong
 */
public class BinaryTreePostorderTraversal145 {

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

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        postorder(root, preorderList);
        return preorderList;
    }
    
    public static List<Integer> postorder(TreeNode root, List<Integer> res) {

        if (null == root) {
            return res;
        }

        if (null != root.left) {
            res = postorder(root.left,res);
        }

        if (null != root.right) {
            res = postorder(root.right, res);
        }

        res.add(root.val);
        
        return res;
    }

    public static void main(String[] args) {

        /**
         * // 输入: [1,null,2,3]
         * //   1
         * //    \
         * //     2
         * //    /
         * //   3
         * //
         * //输出: [3,2,1]
         */
        TreeNode twoLeft = new TreeNode(3, null, null);
        TreeNode oneRight = new TreeNode(2, twoLeft, null);
        TreeNode root = new TreeNode(1, null, oneRight);

        List<Integer> result = postorderTraversal(root);
        System.out.println(result);
        
    }
}
