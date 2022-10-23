/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印 FooBar
 */

// @lc code=start
class FooBar {
    Object lock = new Object();
    private int count = 0;
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                if (count % 2 != 0) {
                    lock.wait();
                }
                printFoo.run();
                count++;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                if (count % 2 != 1) {
                    lock.wait();
                }
                printBar.run();
                count++;
                lock.notifyAll();
            }
        }
    }
}
// @lc code=end
