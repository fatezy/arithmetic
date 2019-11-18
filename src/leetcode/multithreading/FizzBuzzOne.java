package leetcode.multithreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 张亚飞
 * @create 2019-11-18 15:38
 **/
public class FizzBuzzOne {
    class FizzBuzz {
        private int n;
        private Semaphore semaphoreThree;
        private Semaphore semaphoreFive;
        private Semaphore semaphoreThreeAndFive;
        private Semaphore semaphoreNumber;

        public FizzBuzz(int n) {
            this.n = n;
            semaphoreNumber = new Semaphore(1);
            semaphoreThree = new Semaphore(0);
            semaphoreFive = new Semaphore(0);
            semaphoreThreeAndFive = new Semaphore(0);
        }

        //能被三整除但不可被5整除
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    semaphoreThree.acquire();
                    printFizz.run();
                    if (i != n) {
                        notifyNext(i + 1);
                    }

                }
            }
        }

        //能被五整除
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    semaphoreFive.acquire();
                    printBuzz.run();
                    if (i != n) {
                        notifyNext(i + 1);
                    }
                }
            }
        }

        //即3又5
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    semaphoreThreeAndFive.acquire();
                    printFizzBuzz.run();
                    if (i != n) {
                        notifyNext(i + 1);
                    }

                }
            }
        }

        //即不3又不5
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    semaphoreNumber.acquire();
                    printNumber.accept(i);
                    if (i != n) {
                        notifyNext(i + 1);
                    }
                }
            }
        }

        public void notifyNext(int n) {
            if (n % 3 == 0 && n % 5 == 0) {
                semaphoreThreeAndFive.release();
            } else if (n % 3 != 0 && n % 5 == 0) {
                semaphoreFive.release();
            } else if (n % 3 == 0 && n % 5 != 0) {
                semaphoreThree.release();
            } else {
                semaphoreNumber.release();
            }
        }


    }


}
