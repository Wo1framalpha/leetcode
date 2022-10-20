import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

// @lc code=start
class Solution {
    class Node {
        int index;
        int s;
        int e;
        int p;

        Node(int _s, int _e, int _p, int _index) {
            s = _s;
            e = _e;
            p = _p;
            index = _index;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (profit.length == 1) {
            return profit[0];
        }

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            list.add(new Node(startTime[i], endTime[i], profit[i], i));
        }

        Collections.sort(list, (a, b) -> {
            if (a.e != b.e)
                return a.e - b.e;
            else
                return a.p -b.p;
        });

        int[] dp = new int[profit.length];

        dp[0] = list.get(0).p;

        // 遍历按endtime排序后的list
        for (int i = 1; i < dp.length; i++) {
            Node node = list.get(i);
            int n = node.index;
            int stime = startTime[n];

            int x = 0;
            int y = list.size();
            // 二分找到小于开始时间的最后一个node
            while (x < y) {
                int mid = x + (y - x) / 2;
                Node node2 = list.get(mid);

                if (node2.e > stime) {
                    y = mid;
                } else {
                    x = mid + 1;
                }
            }

            dp[i] = x != 0 ? dp[x -1] + node.p : node.p;
            // 这里需要注意一下，取完max之后dp[i]的含义变为到第i位node的组合的收入最大值，而不是包含第i个node的收入组合的最大值
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        return dp[dp.length-1];
    }

    private int maxValue(int[] array, int fromIndex, int toIndex){
        int ret = 0;

        for (int i = fromIndex; i <= toIndex; i++) {
            ret = Math.max(ret, array[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        // new JobScheduling().jobScheduling(new int[] { 4, 2, 4, 8, 2 }, new int[] { 5, 5, 5, 10, 8 }, new int[] { 1, 2, 8, 10, 4 });
    }
}
// @lc code=end
