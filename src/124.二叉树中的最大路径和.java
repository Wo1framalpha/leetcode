/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int res = -1000;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return this.res;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeVal = maxPathSumHelper(root.left);
        int rightSubTreeVal = maxPathSumHelper(root.right);
        int val = root.val + leftSubTreeVal + rightSubTreeVal;
        this.res = Math.max(val, this.res);

        return val < 0 ? 0 : root.val + Math.max(leftSubTreeVal, rightSubTreeVal);
    }

/*     public static void main(String[] args) {
        var instance = new MaxPathSum();
        TreeNode root = instance.new TreeNode(1);
        root.left = instance.new TreeNode(2);
        root.right = instance.new TreeNode(3);
        instance .maxPathSum(root);
    } */
}
// @lc code=end
