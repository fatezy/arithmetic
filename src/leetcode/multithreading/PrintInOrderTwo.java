package leetcode.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量进行的方法
 *
 * semaphore的acquire方法获取信号量。release方法释放信号量，只有acquire
 * 获取到值才能继续执行
 * @author 张亚飞
 * @create 2019-11-15 19:42
 **/
public class PrintInOrderTwo {
    class Foo {
        private Semaphore semaphoreTwo;
        private Semaphore semaphoreThird;
        public Foo() {
            semaphoreTwo = new Semaphore(0);
            semaphoreThird = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphoreTwo.release();

        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphoreTwo.acquire();
            printSecond.run();
            semaphoreThird.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphoreThird.acquire();
            printThird.run();
        }
    }

}
