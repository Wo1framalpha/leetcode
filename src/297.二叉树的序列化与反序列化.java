import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if (node != null) {
                sb.append(String.valueOf(node.val) + ",");
                q.addLast(node.left);
                q.addLast(node.right);

            } else {
                sb.append("X,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        var nodes = data.split(",");

        int child = 1;

        var ret = new TreeNode(Integer.valueOf(nodes[0]));
        var parentNode = ret;
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(parentNode);
        while (child < nodes.length) {
            parentNode = q.pollFirst();

            String left = nodes[child];
            if (!"X".equals(left)) {
                parentNode.left = new TreeNode(Integer.valueOf(left));
                q.addLast(parentNode.left);
            }
            String right = nodes[child+1];
            if (!"X".equals(right)) {
                parentNode.right = new TreeNode(Integer.valueOf(right));
                q.addLast(parentNode.right);
            }

            child += 2;
        }

        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
