/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int mid = i + (j - i) / 2;
            int n = nums[mid];
            if (n >= nums[0]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return nums[i];
    }
}
// @lc code=end
