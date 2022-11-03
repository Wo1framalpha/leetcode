import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 1;

        int i = 0;
        int j = 0;

        set.add(s.charAt(i));

        while (++j<s.length()) {
            // 如果后指针字符重复
            if (set.contains(s.charAt(j))) {
                //前指针前进
                while (s.charAt(i)!=s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i++));
                set.add(s.charAt(j));
            } else {
                set.add(s.charAt(j));
                res = Math.max(res, j-i+1);
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}
// @lc code=end

