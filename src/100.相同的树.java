/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        try {
            dfs(p,q);
            return true;
        } catch (NullPointerException e) {
            // TODO: handle exception
            return false;
        }

    }

    public void dfs(TreeNode p, TreeNode q) {
        if (p.val != q.val) {
            throw new NullPointerException();
        }
        if (p.left != null || q.left != null) {
            dfs(p.left, q.left);
        }
        if (p.right != null || q.right != null) {
            dfs(p.right, q.right);
        }
    }
}
// @lc code=end

