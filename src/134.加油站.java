/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0;
        int cursum = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum+=diff;
            cursum+=diff;
            if (cursum<0) {
                cursum = 0;
                start = i+1;
            }
        }
        if (sum<0) {
            return -1;
        }
        return start;
    }
}
// @lc code=end

