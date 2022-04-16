import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;


/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if(root == null) return res;

        q.add(root);
        while(!q.isEmpty()){
            int num = q.size();
            List<Integer> level = new ArrayList<>();
            while(num-->0){
                Node n = q.poll();
                for(Node child: n.children){
                    q.add(child);
                }
                level.add(n.val);
            }
            res.add(level);
        }
        return res;
    }
}

// @lc code=end

