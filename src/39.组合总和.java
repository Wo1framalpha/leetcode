import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    void combinationSumHelper(int[] candidates, int target, int beginIdx, int currentSum, List<Integer> combination) {
        for (int i = beginIdx; i < candidates.length; i++) {
            int candidate = candidates[i];
            combination.add(candidate);
            if (currentSum + candidate == target) {
                
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(combination);
                combination.remove(combination.size()-1);
                res.add(tmp);
                break;
            } else if (currentSum + candidate < target) {
                combinationSumHelper(candidates, target, i, currentSum + candidate, combination);
            }
            combination.remove(combination.size()-1);
        }
    }


}
// @lc code=end

