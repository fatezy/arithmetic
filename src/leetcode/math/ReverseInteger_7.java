package leetcode.math;

/**
 * author： 张亚飞
 * time：2016/6/25  21:07
 */
//Crackingthecodinginterview.Reverse digits of an integer.
//
//        Example1: x = 123, return 321
//        Example2: x = -123, return -321
    //反转数字
public class ReverseInteger_7 {

    public static int reverse(int x) {
        if (x<0){

            String s = String.valueOf(x*(-1));
            StringBuffer stringBuffer = new StringBuffer(s);
            try {
                int result = Integer.parseInt(stringBuffer.reverse().toString());
                return result*-1;
            }catch (Exception e){
                return 0;
            }

        }else {
            String s = String.valueOf(x);
            StringBuffer stringBuffer = new StringBuffer(s);
            try {
                return Integer.parseInt(stringBuffer.reverse().toString());
            }catch (Exception e){
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(reverse((9646324351)));
        int a = Integer.MAX_VALUE;
        System.out.println( a);

    }

}
