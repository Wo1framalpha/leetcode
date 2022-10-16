/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n ==2) {
            return n;
        }

        int minusone = 2;
        int minustwo = 1;

        int ret = 0;
        for (int i = 3; i <= n ; i++) {
            ret = minusone + minustwo;
            minustwo = minusone;
            minusone = ret;
        }

        return ret;
    }
}
// @lc code=end

