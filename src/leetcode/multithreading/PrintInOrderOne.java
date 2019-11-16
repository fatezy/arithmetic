package leetcode.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch完成任务
 *
 * CountDownLatch的await调用线程阻塞，等到countDown到0时继续执行
 *
 * @author 张亚飞
 * @create 2019-11-15 19:22
 **/
public class PrintInOrderOne {


    class Foo {
        //第二个线程的门锁
        private CountDownLatch latchSecond = new CountDownLatch(1);
        //第三个线程的门锁
        private CountDownLatch latchThird = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            latchSecond.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            latchSecond.await();
            printSecond.run();
            latchThird.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latchThird.await();
            printThird.run();
        }
    }

}
