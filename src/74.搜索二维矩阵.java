/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = n - 1;
        while (true) {
            int value = matrix[j][i];
            if (value == target) {
                return true;
            }
            if (value > target && --j<0) {
                    return false;
            } else if (value < target&&++i>=m) {
                return false;
            }
        }
    }
}
// @lc code=end

