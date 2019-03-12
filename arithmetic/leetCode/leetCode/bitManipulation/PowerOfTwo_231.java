package leetCode.bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/3  22:43
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
       if (n<=0)
           return false;
       else
           return n == (n & -n);
    }
}
