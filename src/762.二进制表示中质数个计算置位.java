import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    // public static void main(String[] args) {
    //     int n = new countPrimeSetBits().countPrimeSetBits(6, 10);
    //     System.out.println(n);
    // }

    List<Integer> primeNumbers = new ArrayList<>();        

    {
        // 1不是质数
        primeNumbers.add(2);
        for (int i = 3; i < 32; i++) {
            isPrime(i);
        }
    }

    public int countPrimeSetBits(int left, int right) {
        Set<Integer> p = new HashSet<>(primeNumbers);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int x = i;
            int cnt = 0;
            while(x!=0){
                x -= (x& -x);
                cnt++;
            }
            if(p.contains(cnt)) ans++;
        }
        return ans;
    }

    public boolean isPrime(int num){
        for (int i = 0; i < primeNumbers.size(); i++) {
            if (num%primeNumbers.get(i)==0) {
                return false;
            }
        }
        primeNumbers.add(num);
        return true;
    }
}
// @lc code=end

