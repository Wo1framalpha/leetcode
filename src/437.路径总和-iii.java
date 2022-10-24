import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    int res = 0;

    Map<Long, Integer> prefixSumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        prefixSumCount.put(0L, 1);

        pathSumHelper(root, targetSum, 0L);

        return res;
    }

    public void pathSumHelper(TreeNode node, int targetSum, Long currentSum) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
        
        res += prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        pathSumHelper(node.left, targetSum, currentSum);
        pathSumHelper(node.right, targetSum, currentSum);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }
}
// @lc code=end
