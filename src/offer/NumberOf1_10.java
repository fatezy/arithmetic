package offer;

/**
 * author： 张亚飞
 * time：2016/5/17  21:33
 */
//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class NumberOf1_10
{
    public static int  NumberOf1(int n) {
       int resullt =0;
        for (int i = 0; i <32 ; i++) {
            if (((n>>i)&1) ==1){
                resullt++;
            }

        }
        return resullt;
    }


//    public static void main(String[] args) {
//        System.out.println(NumberOf1(5));
//    }
}
