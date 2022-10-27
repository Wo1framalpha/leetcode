/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = 0;
        int j = 0;
        // 最开始一段非0元素不用操作，直接跳过
        while (i< nums.length && nums[i]!=0 && i++==j++){}
        while (i< nums.length) {
            // 找到一个非0元素
            if (nums[i] != 0) {
                // 和0元素（j所指）交换
                swap(nums, i, j);
                // 有序区右移一位
                j++;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

