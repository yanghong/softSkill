package com.hunter.leetcode.binaryTree;

//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 474 👎 0


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
 * @author yanghong
 */

public class MiddleOrFontMadeBinaryTree106 {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder , 0, inorder.length - 1, postorder, 0, postorder.length - 1 );

    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd) {

        if (null == inorder || null == postorder || inStart > inEnd || pStart > pEnd) {
            return null;
        }

        // root value
        int rootVal = postorder[pEnd];

        TreeNode root = new TreeNode(rootVal);

        int index = findInorderIndex(rootVal, inorder);

        int leftSize = index - inStart;
        root.left = buildTree(inorder, inStart, index - 1, postorder, pStart, pStart + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, pStart + leftSize, pEnd - 1);

        return root;
    }

    private static int findInorderIndex(int root, int[] inorder) {
        if (null == inorder) {
            return -1;
        }
        for (int i = 0; i < inorder.length; i++) {

            if (root == inorder[i]) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode node = buildTree(inorder, postorder);

        System.out.println(node);

    }
}
