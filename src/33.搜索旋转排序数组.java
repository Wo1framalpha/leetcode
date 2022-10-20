/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int i = 0;
        int j = nums.length;
        boolean isLeft = nums[0] <= target;

        while (i < j) {
            int mid = i + (j - i) / 2;
        
            if (nums[mid] == target) {
                return mid;
            }

            if (isLeft) {
                if (nums[mid] < nums[0]) {
                    j = mid;
                } else if (target < nums[mid]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] > nums[0]) {
                   i = mid + 1;
                } else if (target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
