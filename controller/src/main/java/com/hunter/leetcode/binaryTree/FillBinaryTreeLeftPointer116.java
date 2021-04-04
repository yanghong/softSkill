package com.hunter.leetcode.binaryTree;

//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 提示：
//
//
// 树中节点的数量少于 4096
// -1000 <= node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

public class FillBinaryTreeLeftPointer116 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if (null == root) {
            return null;
        }

        connectTwoNode(root.left, root.right);

        return root;
    }

    private static void connectTwoNode(Node left, Node right) {

        if (left == null || right == null) {
            return;
        }

        left.next = right;

        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        Node treeNode4 = new Node(4, null, null, null);
        Node treeNode5 = new Node(5, null, null, null);
        Node treeNode6 = new Node(6, null, null,null);
        Node treeNode7 = new Node(7, null, null,null);
        Node treeNode2 = new Node(2, treeNode4, treeNode5, null);
        Node treeNode3 = new Node(3, treeNode6, treeNode7, null);
        Node treeNode1 = new Node(1, treeNode2, treeNode3, null);
        Node node = connect(treeNode1);
        System.out.println(node);
    }
}
