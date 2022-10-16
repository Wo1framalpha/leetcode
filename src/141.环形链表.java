/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        try {
            ListNode node1 = head;
            ListNode node2 = head.next;
            while (node1 != node2) {

                node1 = node1.next;
                node2 = node2.next.next;

            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
// @lc code=end
