package com.hunter.leetcode;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/25 16:28
 */
public class Solution2 {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode preNode = new ListNode();
        boolean ifNeedAddOne = false;
        boolean firstCal = true;

        while (null != l1 || null != l2) {
            ListNode node = new ListNode();
            int l1Value = 0;
            int l2Value = 0;
            if (null != l1) {
                l1Value = l1.val;
            }

            if (null != l2) {
                l2Value = l2.val;
            }

            if (ifNeedAddOne) {
                if (null == l1) {
                    l2Value = l2Value + 1;
                    node.val = gtTenLeftValue(0, l2Value);
                } else if (null == l2){
                    l1Value = l1Value + 1;
                    node.val = gtTenLeftValue(l1Value, 0);
                } else {
                    l1Value = l1Value + 1;
                    node.val = gtTenLeftValue(l1Value, l2Value);
                }

            } else {

                if (null == l1) {
                    node.val = gtTenLeftValue(0, l2Value);
                } else if (null == l2){
                    node.val = gtTenLeftValue(l1Value, 0);
                } else {
                    node.val = gtTenLeftValue(l1Value, l2Value);
                }
            }

            ifNeedAddOne = judge(l1Value, l2Value);

            if(firstCal) {
                result = node;
                firstCal = false;
                preNode = result;
            } else {
                preNode.next = node;
                preNode = node;
            }

            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }

            if (null == l1 && null == l2 && ifNeedAddOne) {
                ListNode lastNode = new ListNode();
                lastNode.val = 1;
                preNode.next = lastNode;
            }
        }
        return result;
    }

    // 判断两个数相加是否需要向前一位加1
    private static boolean judge(int nodeValue1, int nodeValue2) {
        if (nodeValue1 + nodeValue2 >= 10) {
            return true;
        } else {
            return false;
        }
    }

    private static int gtTenLeftValue(int nodeValue1, int nodeValue2) {

        int sum = nodeValue1 + nodeValue2;

        if (sum >= 10) {
            return sum%10;
        } else {
            return sum;
        }
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        System.out.println(addTwoNumbers(l1, l2));
    }
}
