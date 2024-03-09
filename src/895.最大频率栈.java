/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start

import java.util.*;

class FreqStack {
    private Map<Integer, Integer> val2freqMap = new HashMap<>();
    private Map<Integer, Deque<Integer>> freq2valMap = new HashMap<>();
    private int maxFreq = 0;


    public FreqStack() {

    }
    
    public void push(int val) {
        Integer varFreq = val2freqMap.getOrDefault(val, 0) + 1;
        val2freqMap.put(val, varFreq);
        Deque<Integer> sequence = freq2valMap.getOrDefault(varFreq, new LinkedList<>());
        sequence.offerFirst(val);
        freq2valMap.put(varFreq, sequence);
        maxFreq = Math.max(maxFreq, varFreq);
    }
    
    public int pop() {
        Deque<Integer> sequence = freq2valMap.get(maxFreq);
        Integer val = sequence.pollFirst();
        if (sequence.isEmpty()) {
            maxFreq--;
        }

        val2freqMap.put(val, val2freqMap.get(val) - 1);
        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();

        freqStack.push(1);
        freqStack.push(2);
        freqStack.push(3);
        freqStack.push(2);
        freqStack.push(1);
        freqStack.push(2);

        System.out.println(freqStack.pop());  // Expected output: 2
        System.out.println(freqStack.pop());  // Expected output: 1
        System.out.println(freqStack.pop());  // Expected output: 2
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

