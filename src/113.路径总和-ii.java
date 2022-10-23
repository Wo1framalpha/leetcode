import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> q = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            dfs(root, targetSum, 0);
        }
        return res;
    }

    public void dfs(TreeNode root, int targetSum, int sum) {
        q.addLast(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                List<Integer> dest = new ArrayList(q);

                res.add(dest);
            }
            q.pollLast();
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum, sum);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, sum);
        }
        q.pollLast();

    }
}
// @lc code=end
