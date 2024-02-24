/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> context = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        recursion(nums, 0);
        
        return res;
    }

    private void recursion(int[] nums, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(context));
        } else {
            //不包含该index位置的元素
            recursion(nums, index + 1);

            //包含该index位置的元素
            context.add(nums[index]);
            recursion(nums, index + 1);
            context.remove(context.size() - 1);

        }
    }
}
// @lc code=end

