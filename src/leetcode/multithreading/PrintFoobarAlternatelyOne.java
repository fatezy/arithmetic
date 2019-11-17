package leetcode.multithreading;

import java.util.concurrent.Semaphore;

/**
 * 将并发调用转变成顺序调用
 *
 * 使用信号量 Semaphore
 * @author 张亚飞
 * @create 2019-11-16 17:06
 **/
public class PrintFoobarAlternatelyOne {

    class FooBar {
        private int n;
        private Semaphore semaphoreFoo = new Semaphore(1);
        private Semaphore semaphoreBar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreFoo.acquire();
                printFoo.run();
                semaphoreBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreBar.acquire();
                printBar.run();
                semaphoreFoo.release();
            }
        }
    }
}
