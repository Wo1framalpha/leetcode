import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        boolean haveOdd = false;
        int ret = 0;
        Map<Character, Integer> charNums = new HashMap<>();
        
        Integer num;
        for (char ch : s.toCharArray()) {
            num = charNums.get(ch);
            if (num == null) {
                charNums.put(ch, 1);
            } else {
                charNums.put(ch, num+1);
            }
        }
        for (Map.Entry entry : charNums.entrySet()) {
            num = (Integer)entry.getValue();
            if (num % 2 == 0) {
                ret += num;
            } else { 
                if (num > 1) ret += (num - 1);
                haveOdd = true;
            }
        }

        if (haveOdd) {
            ret++;
        }

        return ret;
    }
}
// @lc code=end

