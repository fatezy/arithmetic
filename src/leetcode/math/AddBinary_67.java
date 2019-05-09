package leetcode.math;

/**
 * author： 张亚飞
 * time：2016/5/25  16:01
 */
//Given two binary strings, return their sum (also a binary first.leetCode.string).
//
//        For example,
//        a = "11"
//        b = "1"
//        Return "100".
public class AddBinary_67 {
    //32位一下没问题
    public static String addBinary(String a, String b) {
        int result = 0;
        for (int i = 0; i <a.length() ; i++) {
            if (a.charAt(i)=='1'){
                result += Math.pow(2,a.length()-i-1);
            }
        }
        for (int i = 0; i <b.length() ; i++) {
            if (b.charAt(i)=='1'){
                result += Math.pow(2,b.length()-i-1);
            }
        }

        return  Integer.toBinaryString(result);
    }
//优秀解法
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("10101", "110101"));
    }

}
