import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印 FooBar
 */

// @lc code=start
class FooBar {
    private CyclicBarrier cb = new CyclicBarrier(2);
    private volatile boolean fooFlag = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!fooFlag) {}
            printFoo.run();
            fooFlag = false;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            printBar.run();
            fooFlag = true;
            
        }
    }
}
// @lc code=end
