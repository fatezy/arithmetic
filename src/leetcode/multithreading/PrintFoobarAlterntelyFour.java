package leetcode.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock公平锁(超时)
 *
 * @author 张亚飞
 * @create 2019-11-17 9:46
 **/
public class PrintFoobarAlterntelyFour {



    class FooBar {
        private int n;
        private boolean permitFoo;
        private Lock lock;
        public FooBar(int n) {
            this.n = n;
            this.permitFoo = false;
            //公平锁
            this.lock = new ReentrantLock(true);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n;) {
                try {
                    lock.lock();
                    if (permitFoo) {
                        printFoo.run();
                        i++;
                        permitFoo = false;
                    }
                }finally {
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n;) {
                lock.lock();
                try {
                    if (!permitFoo) {
                        printBar.run();
                        i++;
                        permitFoo = true;
                    }
                }finally {
                    lock.unlock();
                }

            }
        }
    }


}
