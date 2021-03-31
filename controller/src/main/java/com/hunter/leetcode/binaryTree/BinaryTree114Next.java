package com.hunter.leetcode.binaryTree;

public class BinaryTree114Next {

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

    private static void flatten(TreeNode root) {

        if (null == root) {
            return;
        }

        while(root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
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
        System.out.println(treeNode1);
    }


}
