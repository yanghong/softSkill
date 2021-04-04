package com.hunter.leetcode.binaryTree;

// 根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
// 你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder =[3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 970 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
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

public class FirstOrMiddleMadeBinaryTree105 {

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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length -1,
                inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (null == preorder || null == inorder || preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历
        int root = preorder[preStart];

        int index = findInorderIndex(root, inorder);

        int leftSize = index - inStart;

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        rootNode.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return rootNode;

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
        // 前序遍历 preorder =[3,9,20,15,7]
        // 中序遍历 inorder = [9,3,15,20,7]

//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};

        int[] preorder = {3,1,2,4};
        int[] inorder = {1,2,3,4};

        TreeNode node = buildTree(preorder, inorder);

        // 解答失败: 测试用例:[3,1,2,4] [1,2,3,4] 测试结果:[3,1,null,null,2] 期望结果:[3,1,4,null,2] stdout

        System.out.println(node);

    }
}
