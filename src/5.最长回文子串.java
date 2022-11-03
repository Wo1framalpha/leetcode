/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String res = "";
        
        // 遍历中心
        for (int i = 0; i < s.length()-1; i++) {
            String tmp = getPalindrome(s, i, i);
            if (tmp.length()>res.length()) {
                res=tmp;
            }
            tmp = getPalindrome(s, i, i+1);
            if (tmp.length()>res.length()) {
                res=tmp;
            }
        }

        return res;
    }

    public String getPalindrome(String s, int leftCenter, int rightCenter ) {
        int distance = 0;
        while (leftCenter-distance>=0&&rightCenter+distance<s.length()) {
            if (s.charAt(leftCenter-distance)==s.charAt(rightCenter+distance)) {
                distance++;
            } else {
                
                break;
            }
        }
        distance--;
        if (distance == -1) {
            return s.substring(leftCenter, rightCenter);
        } else {
            return s.substring(leftCenter-distance, rightCenter+distance+1);
        }
    }

}
// @lc code=end

