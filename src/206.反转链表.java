/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = reverse(head);
        head.next = null;
        return res;
    }

    private ListNode reverse(ListNode node){
        if (node.next==null) {
            return node;
        }
        ListNode  head = reverse(node.next);
        node.next.next = node;
        return head;
    }
}
// @lc code=end

