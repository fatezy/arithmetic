package leetcode.bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/5  16:42
 */
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//        For example, given the range [5, 7], you should return 4.
    //给你一个区间，求区间中所有数&运算后的结果
public class BitwiseANDofNumbersRange_201 {
    //他奶奶的，一轮运算还超时
    public int rangeBitwiseAnd2(int m, int n) {
        int res = m;
        for (int i = m; i <=n ; i++) {
            res &= i;

        }
        return res;

    }

//找m与n相同的前缀
    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n<<diffBits;
    }


    public int rangeBitwiseAnd3(int m, int n) {
        return m == n ? m : m & ~((Integer.highestOneBit(m ^ n) << 1) - 1);
    }

}
