/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 二分法找出第一个大于等于0的元素
        int i=0;
        int j = nums.length;
        while (i<j) {
            int mid = i + (j-i)/2;
            if (nums[mid] < 0) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        // 合并有序数组
        int[] sorted = new int[nums.length];
        int sortedIndex = 0;
        int left = i-1;
        int right = i;
        while (left>=0 && right<nums.length) {
            int leftNum = -nums[left];
            int rightNum = nums[right];
            if (leftNum < rightNum) {
                sorted[sortedIndex++]=leftNum;
                left--;
            }else{
                sorted[sortedIndex++]=rightNum;
                right++;
            }
        }
        while (left>=0) {
            int leftNum = -nums[left];
            sorted[sortedIndex++]=leftNum;
                left--;
        }
        while (right<nums.length) {
            int rightNum = nums[right];
            sorted[sortedIndex++]=rightNum;
                right++;
        }
        // 输出平方数组
        for (int k = 0; k < sorted.length; k++) {
            int tmp = sorted[k];
            sorted[k]=tmp*tmp;
        }
        return sorted;
    }
}
// @lc code=end

