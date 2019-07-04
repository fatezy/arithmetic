package 左程云;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 换钱最少货币数 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    public static void main(String[] args) {
        换钱最少货币数 main = new 换钱最少货币数();
        int[] arr = {419,186,83,408};
        System.out.println(main.coinChange(arr, 6269));

    }


}
