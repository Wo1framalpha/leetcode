/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // zero区[0,zero)
        // two区(two,nums.length-1]
        // one区[zero,i)
        // 未定[i,two]
        int zero = 0;
        int two = nums.length-1;
        int i = 0;
        while (i<=two) {
            int num = nums[i];
            if (num == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (num==1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
        
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

