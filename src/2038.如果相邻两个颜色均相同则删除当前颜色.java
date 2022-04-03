/*
 * @lc app=leetcode.cn id=2038 lang=java
 *
 * [2038] 如果相邻两个颜色均相同则删除当前颜色
 */

// @lc code=start
class Solution {
    public boolean winnerOfGame(String colors) {
        char[] colorArray = colors.toCharArray();
        int num = colorArray.length;
        int a=0,b=0;
        for(int i = 1;i<num-1;i++){
            if(colorArray[i]=='A'&&colorArray[i-1]=='A'&&colorArray[i+1]=='A') a++;
            if(colorArray[i]=='B'&&colorArray[i-1]=='B'&&colorArray[i+1]=='B') b++;

        }
        return a>b;
    }
}
// @lc code=end

