package leetcode.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock进行
 *
 * @author 张亚飞
 * @create 2019-11-15 20:03
 **/
public class PrintInOrderThree {
    public static void main(String[] args) throws InterruptedException {


        Foo foo = new Foo();

        Thread[] thread = new Thread[3];
        thread[0] = new TaskA(foo,new First());
        thread[1] = new TaskB(foo,new Second());
        thread[2] = new TaskC(foo,new Third());

        thread[2].start();
        thread[1].start();
        thread[0].start();

        for (int i = 0; i <thread.length ; i++) {
            thread[i].join();
        }

        System.out.println("主线程结束");

    }



}

class TaskA extends Thread{
    private Foo foo;
    private Runnable runnable;

    public TaskA(Foo foo,Runnable runnable){
        this.foo = foo;
        this.runnable = runnable;
    }
    @Override
    public void run() {
        try {
            foo.first(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class TaskB extends Thread{
    private Foo foo;
    private Runnable runnable;

    public TaskB(Foo foo,Runnable runnable){
        this.foo = foo;
        this.runnable = runnable;
    }
    @Override
    public void run() {
        try {
            foo.second(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskC extends Thread{
    private Foo foo;
    private Runnable runnable;

    public TaskC(Foo foo,Runnable runnable){
        this.foo = foo;
        this.runnable = runnable;
    }
    @Override
    public void run() {
        try {
            foo.third(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class First implements Runnable{

    @Override
    public void run() {
        System.out.println("first 线程执行");
    }
}

class Second implements Runnable{

    @Override
    public void run() {
        System.out.println("second 线程执行");
    }
}


class Third implements Runnable{

    @Override
    public void run() {
        System.out.println("third 线程执行");
    }
}


class Foo {
    Lock lock;
    volatile int state;
    Condition condition2;
    Condition condition3;

    public Foo() {
        lock = new ReentrantLock();
        state = 1;
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            state = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (state != 2) {
                condition2.await();
            }
            printSecond.run();
            state = 3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (state != 3) {
                condition3.await();
            }
            printThird.run();
        }finally {
            lock.unlock();
        }
    }
}