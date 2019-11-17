package leetcode.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 将并发调用转变成顺序调用
 *
 * 使用 lock（非公平锁）,暂时不能跑，回头再试
 * @author 张亚飞
 * @create 2019-11-16 17:06
 **/
public class PrintFoobarAlternatelyTwo {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        Thread[] threads = new Thread[2];
        threads[0] = new FooThread(fooBar);
        threads[1] = new BarThread(fooBar);
        threads[0].start();
        threads[1].start();
        for (int i = 0; i <threads.length ; i++) {
            threads[i].join();
        }

        System.out.println("执行结束");
    }


}


class FooBar {
    private int n;
    private Lock lock;
    private Condition fooCondition;
    private Condition barCondition;
    private volatile boolean fooTurn;


    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.fooCondition = lock.newCondition();
        this.barCondition = lock.newCondition();
        this.fooTurn = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if (!fooTurn) {
                    fooCondition.wait();
                }
                printFoo.run();
                fooTurn = false;
                barCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();

                if (fooTurn){
                    barCondition.wait();
                }
                printBar.run();
                fooCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

class FooThread extends Thread{
    FooBar fooBar;
    FooThread(FooBar fooBar){
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        super.run();
        try {
            fooBar.foo(()-> System.out.println("foo Thread print"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class BarThread extends Thread{
    FooBar fooBar;
    BarThread(FooBar fooBar){
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        super.run();
        try {
            fooBar.bar(()-> System.out.println("bar Thread print"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}