package Backtracking;

/**
 * author： 张亚飞
 * time：2016/7/27  17:01
 */
//Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
//
//        Example:
//        Given n = 2, return 91. (The answer should be the total number
// s in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
    //找出所有各个位置都不相同的数
public class CountNumberswithUniqueDigits_357 {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if(n>=11) return 8877691;
        int res =10;
        for (int i = 2; i <=n ; i++) {
            int temp =9;
            for (int j = 0; j <i-1 ; j++) {
                temp *=(9-j);
            }
            res += temp;
        }
        return res;
    }


    public static int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(10));
        System.out.println(countNumbersWithUniqueDigits2(11));
    }
}
