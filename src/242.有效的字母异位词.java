import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] sarray = new int[128];
        int[] tarray = new int[128];

        for (char ch : s.toCharArray()) {
            sarray[ch]+=1;
        }
        for (char ch : t.toCharArray()) {
            tarray[ch]+=1;
        }
        return Arrays.compare(sarray, tarray) == 0;
    }
}
// @lc code=end

