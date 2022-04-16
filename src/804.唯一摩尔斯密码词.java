import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseDict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseRep = new HashSet<>();
        for (String s : words){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<s.length();i++){
                sb.append(morseDict[s.charAt(i)-'a']);
            }
            morseRep.add(sb.toString());
        }
        return morseRep.size();
    }
}
// @lc code=end

