import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
        }

        int ret = dp[0];
        for (int i = 1; i < dp.length; i++) {
            ret = Math.max(ret, dp[i]);
        }

        return ret;

    }

    // public static void main(String[] args) {
    //     (new Solution()).maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    // }
}
// @lc code=end

