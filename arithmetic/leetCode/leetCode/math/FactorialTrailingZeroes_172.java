package leetCode.math;

/**
 * author： 张亚飞
 * time：2016/6/15  23:26
 */
//Given an integer n, return the number of trailing zeroes in n!.
    //求出n的阶乘中0的个数
    //本题其实是求n的阶乘中5的个数
public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
