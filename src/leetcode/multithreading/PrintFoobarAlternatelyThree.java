package leetcode.multithreading;

import java.util.concurrent.Semaphore;

/**
 * 将并发调用转变成顺序调用
 *
 * 无锁化编程
 * @author 张亚飞
 * @create 2019-11-16 17:06
 **/
public class PrintFoobarAlternatelyThree {





    class FooBar {
        private int n;
        private volatile boolean fooTurn;

        public FooBar(int n) {
            this.n = n;
            this.fooTurn = true;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n;) {
                 if (fooTurn) {
                     printFoo.run();
                     fooTurn = false;
                     i++;
                 }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n;) {
                if (!fooTurn) {
                    printBar.run();
                    fooTurn = true;
                    i++;
                }
            }
        }
    }

}




