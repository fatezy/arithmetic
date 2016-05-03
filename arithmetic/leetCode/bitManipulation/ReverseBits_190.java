package bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/3  23:01
 */
//Reverse bits of a given 32 bits unsigned integer.
//
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
//return 964176192 (represented in binary as 00111001011110000010100101000000).
    //把int转化为二进制，并逆序
public class ReverseBits_190 {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i<32 ; i++) {
            if (((n >> i)&1) == 1 ){
                res |= 1<<(31-i);

            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(1));
    }

}
