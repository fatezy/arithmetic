package hashmap;

/**
 * author： 张亚飞
 * time：2016/10/24  20:06
 */
//Count the number of prime numbers less than a non-negative number, n.
    //给你一个数n求出小于n的素数个数
public class CountPrimes_204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
