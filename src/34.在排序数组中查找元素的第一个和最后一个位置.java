/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int i = 0;
        int j = nums.length;
        while (i<j) {
            int mid = i+(j-i)/2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (i >=nums.length || nums[i]!=target ) {
            return new int[]{-1,-1};
        }
        int begin = i;
        while (++i<nums.length && nums[i] == target) {}
        return new int[]{begin,i-1};
    }
}
// @lc code=end

