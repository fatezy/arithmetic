package leetcode.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 无锁化编程，就是让线程死转
 *
 * @author 张亚飞
 * @create 2019-11-16 16:49
 **/
public class PrintInOrderFour {
    class Foo {
        volatile int state = 1;
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            state = 2;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (state != 2);
            printSecond.run();
            state = 3;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (state != 3);
            printThird.run();
        }
    }


}
