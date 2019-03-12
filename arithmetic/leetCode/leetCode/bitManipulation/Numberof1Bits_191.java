package leetCode.bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/2  17:21
 */
//Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
//
//        For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
//判断二进制数中1的个数
public class Numberof1Bits_191 {
    public static int hammingWeight(int n) {
        int res = 0;
        //闲的蛋疼，试试他给的例子怎么样
        for (int i = -1; i <31 ; i++) {
            if (((n >> i)&1) == 1 ){
                res++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
