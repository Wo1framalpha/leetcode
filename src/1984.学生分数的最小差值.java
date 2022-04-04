/*
 * @lc app=leetcode.cn id=1984 lang=java
 *
 * [1984] 学生分数的最小差值
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 100010;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, k, nums))
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }

    boolean check(int x, int k, int[] nums) {
        int n = nums.length;
        int ans = nums[k - 1] - nums[0];
        for (int i = k; i < n && ans > x; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans <= x;
    }

}

// @lc code=end
