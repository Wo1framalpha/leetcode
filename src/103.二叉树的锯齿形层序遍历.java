import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        // 表示读取顺序
        boolean order = true;

        q.addFirst(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> layer = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode tmp = null;
                // 该层子节点的入队列顺序与读取顺序相反
                if (order) {
                    tmp = q.pollFirst();

                    if (tmp.left != null) {
                        q.addLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        q.addLast(tmp.right);
                    }
                } else {
                    tmp = q.pollLast();

                    if (tmp.right != null) {
                        q.addFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        q.addFirst(tmp.left);
                    }
                }
                layer.add(tmp.val);

            }
            order = !order;
            res.add(layer);
        }

        return res;
    }
}
// @lc code=end
