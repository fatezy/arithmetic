package leetcode.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 *CyclicBarrier，当指定数目的线程到达栅栏处，则执行，即所以线程都调用wait之后执行
 * @author 张亚飞
 * @create 2019-11-16 16:55
 **/
public class PrintInOrderFive {
    class Foo {
        CyclicBarrier cb1 = new CyclicBarrier(2);
        CyclicBarrier cb2 = new CyclicBarrier(2);

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            try {
                cb1.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException{
            try {
                cb1.await();
                printSecond.run();
                cb2.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void third(Runnable printThird) throws InterruptedException{
            try {
                cb2.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printThird.run();
        }
    }

}
