package leetCode.bitManipulation;

/**
 * author： 张亚飞
 * time：2016/7/17  16:39
 */
//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//        Example:
//        Given a = 1 and b = 2, return 3.
    //不可以使用+进行加法
public class SumofTwoIntegers_371 {
    public static int getSum(int a, int b) {

        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum(20, 30));
    }
}
