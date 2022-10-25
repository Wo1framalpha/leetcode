/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i]=nums[i-1]*res[i-1];
        }
        int R = 1;

        for (int i = nums.length - 1; i >=0  ; i--) {
            res[i] *= R;
            R*=nums[i];
        }
        
    
        return res;
    }
}
// @lc code=end

