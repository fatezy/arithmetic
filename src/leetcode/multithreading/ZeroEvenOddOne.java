package leetcode.multithreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 张亚飞
 * @create 2019-11-17 16:07
 **/
public class ZeroEvenOddOne {
    public static void main(String[] args) throws InterruptedException {


        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        Thread[] threads = new Thread[3];
        threads[0] = new ThreadB(zeroEvenOdd);
        threads[1] = new ThreadA(zeroEvenOdd);
        threads[2] = new ThreadC(zeroEvenOdd);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        //要放在一起join,因为一旦join，主线程什么都做不了了
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("结束");
    }
}


class ZeroEvenOdd {
    private int n;
    private Semaphore semZero;
    private Semaphore semEven;
    private Semaphore semOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.semZero = new Semaphore(1);
        this.semEven = new Semaphore(0);
        this.semOdd = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semEven.release();
            } else {
                semOdd.release();
            }
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                semEven.acquire();
                printNumber.accept(i);
                semZero.release();
            }
        }
    }

    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                semOdd.acquire();
                printNumber.accept(i);
                semZero.release();
            }
        }
    }

}



class ThreadA extends Thread {
    private ZeroEvenOdd zeroEvenOdd;

    ThreadA(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        super.run();
        try {
            zeroEvenOdd.zero(i -> System.out.println(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private ZeroEvenOdd zeroEvenOdd;

    ThreadB(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        super.run();
        try {
            zeroEvenOdd.even(i -> System.out.println(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread {
    private ZeroEvenOdd zeroEvenOdd;

    ThreadC(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        super.run();
        try {
            zeroEvenOdd.odd(i -> System.out.println(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}