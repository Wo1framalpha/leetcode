import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return parse(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode parse(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend) {
        if (pbegin >= pend) {
            return null;
        }
        TreeNode res = new TreeNode(preorder[pbegin]);
        int iRootIndex = index.get(preorder[pbegin]);
        int leftLen = iRootIndex - ibegin;

        res.left = parse(preorder, pbegin + 1, pbegin + leftLen + 1, inorder, ibegin, iRootIndex);
        res.right = parse(preorder, pbegin + leftLen + 1, pend, inorder, iRootIndex + 1, iend);

        return res;
    }
}
// @lc code=end
