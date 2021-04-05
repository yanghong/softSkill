package com.hunter.leetcode;

// 用一个非空的单链表来表示一个非负整数，然后将这个整数加一。
// 你可以假设这个整数除了0和本身，没有任何前导的零
// 这个整数的各个数位按照高位在链表头部，低位在链表尾部的顺序排列。
// 示例：
// 输入：[1,2,3]
// 输出：[1,2,4]

/**
 * @author yanghong
 */
public class PlusOne369 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        // 它的下一个节点值为 9，万一需要进位
        ListNode attention = newHead;
        ListNode index = head;
        while (index.next != null) {
            if (index.val != 9 && index.next.val == 9) {
                // 下一个为 9，做好进位的准备
                attention = index;
            }
            index = index.next;
        }
        if (index.val == 9) {
            ListNode tmp = attention.next;
            // attention后面全变为 0
            while (tmp != null) {
                tmp.val = 0;
                tmp = tmp.next;
            }
            attention.val = attention.val + 1;
        } else {
            index.val = index.val + 1;
        }
        return newHead.val == 0 ? newHead.next : newHead;
    }
}
