package com.hunter.leetcode.binaryTree;

//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//     1
//   /   \
//  2     5
// / \   / \
//3   4 n   6
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
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 树 深度优先搜索

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

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/3/30 20:22
 */
public class BinaryTreeToLinked114 {

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

    public static void flatten(TreeNode root) {

        if (null == root) {
            return;
        }

        List<Integer> result = new ArrayList<>();

        changeNode(result, root);

        TreeNode tmp = null;
        for (Integer item : result) {
            TreeNode treeNode = new TreeNode(item);
            treeNode.left = null;
            if (null == tmp) {
                root = treeNode;
                tmp = treeNode;
            }
            tmp.right = treeNode;
            tmp = tmp.right;
        }
    }

    public static void changeNode(List<Integer> result, TreeNode root) {

        if (null != root) {

            result.add(root.val);

            if (null != root.left) {
                changeNode(result, root.left);
            }

            if (null != root.right) {
                changeNode(result, root.right);
            }
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode4 = new TreeNode(3, null, null);
        TreeNode treeNode5 = new TreeNode(4, null, null);
        TreeNode treeNode7 = new TreeNode(6, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(5, null, treeNode7);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        flatten(treeNode1);
    }

}
