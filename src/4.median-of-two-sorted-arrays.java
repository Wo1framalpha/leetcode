/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length%2 == 0 ){
            int index1 = length/2 - 1;
            int index2 = length/2;

            int index = 0;
            int output = 0;
            int cursor1 = 0;
            int cursor2 = 0;
            while(index++!=index1){
                if(nums1[cursor1] < nums2[cursor2]){
                    cursor1++;
                } else{
                    cursor2++;
                }
            }
            
        }
    }
}
// @lc code=end

