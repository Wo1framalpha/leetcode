import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MinStack() {
        stack = new  Stack<>();
        minStack = new  Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(minStack.isEmpty()||val<=getMin()){
            minStack.add(val);
        }
    }
    
    public void pop() {
        // 注意Integer之间的相等比较不能用 == ，要用equals()
        if(minStack.peek().equals(stack.pop())){
           minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

