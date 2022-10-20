/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int pointer1 = 0, pointer2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (pointer1 < m && (pointer2 >= n || nums1[pointer1] < nums2[pointer2])) {
                right = nums1[pointer1++];
            } else {
                right = nums2[pointer2++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }
}
// @lc code=end

