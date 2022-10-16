import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        char ch;
        Integer num;

        for (int i = 0; i < ransomNote.length(); i++) {
            ch = ransomNote.charAt(i);
            num = ransomNoteMap.get(ch);

            if (num != null) {
                ransomNoteMap.put(ch, num + 1);
            } else {
                ransomNoteMap.put(ch, 1);
            }
        }

        for (int i = 0; i < magazine.length(); i++) {
            ch = magazine.charAt(i);
            num = magazineMap.get(ch);

            if (num != null) {
                magazineMap.put(ch, num + 1);
            } else {
                magazineMap.put(ch, 1);
            }
        }

        for (Map.Entry entry : ransomNoteMap.entrySet()) {
            Integer n = magazineMap.get(entry.getKey());
            if (n == null || n < (Integer)entry.getValue()) return false;
        }

        return true;
    }
}
// @lc code=end

