import javax.swing.text.html.HTMLDocument.RunElement;

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color != image[sr][sc]) {
            helper(image, sr, sc, color,image[sr][sc]);
        }
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int color, int originColor) {
        if (sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=originColor){
            return;
        }
        image[sr][sc] = color;
        helper(image, sr-1, sc, color, originColor);
        helper(image, sr, sc-1, color, originColor);
        helper(image, sr+1, sc, color, originColor);
        helper(image, sr, sc+1, color, originColor);
    }
}
// @lc code=end

