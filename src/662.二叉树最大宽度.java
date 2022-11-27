import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();

        root.val = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int begin = q.peek().val;
            int end = begin;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                int index = node.val;
                end = index;
                if (node.left != null) {
                    node.left.val = index * 2 - 1;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = index * 2;
                    q.offer(node.right);
                }
            }
            res = Math.max(res, end - begin + 1);
        }

        return res;
    }

}
// @lc code=end
