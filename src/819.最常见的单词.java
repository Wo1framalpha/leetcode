import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split(" |\\!|\\?|'|\\;|\\.|,");
        Map<String, Integer> wordsMap = new HashMap<>();
        Set<String> bannedWords = new HashSet<>(100);

        for (String s : banned) {
            bannedWords.add(s);
        }
        bannedWords.add("");
        for (String s : words) {
            if (wordsMap.containsKey(s)) {
                wordsMap.put(s, wordsMap.get(s) + 1);
            } else {
                wordsMap.put(s, 1);
            }
        }
        int resNum = 0;
        String resWord = "";
        for (Map.Entry m : wordsMap.entrySet()) {
            if (!bannedWords.contains(m.getKey())) {
                if ((Integer) m.getValue() > resNum) {
                    resNum = (Integer) m.getValue();
                    resWord = (String) m.getKey();
                }
            }
        }
        return resWord;
    }
}
// @lc code=end
