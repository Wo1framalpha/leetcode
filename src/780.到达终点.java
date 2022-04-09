/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 到达终点
 */

// @lc code=start
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 参考https://pic.leetcode-cn.com/1649464812-VyZUyF-image.png

        // 从终点往起点走
        while (sx < tx && sy < ty) {
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;
        }
        
        if (tx < sx || ty < sy)
            return false;
        // 如果结果为TRUE，这时tx或ty必然有一个到了，剩下没到的那个距离起点只需要减去若干个到了的值即可
        if (tx == sx) {
            return (ty - sy) % tx == 0;
        } else {
            return (tx - sx) % ty == 0;
        }
    }
}
// @lc code=end
