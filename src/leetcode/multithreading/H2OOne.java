package leetcode.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author 张亚飞
 * @create 2019-11-17 20:47
 **/
public class H2OOne {

    class H2O {

        private CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                semaphoreH.release(2);
                semaphoreO.release();
            }
        });

        private Semaphore semaphoreH;
        private Semaphore semaphoreO;

        public H2O() {
            semaphoreH = new Semaphore(2);
            semaphoreO = new Semaphore(1);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            semaphoreH.acquire();
            releaseHydrogen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            semaphoreO.acquire();
            releaseOxygen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


}
