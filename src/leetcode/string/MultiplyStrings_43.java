package leetcode.string;

/**
 * author： 张亚飞
 * time：2016/7/20  20:03
 */
//Given two numbers represented as strings, return multiplication of the numbers as a first.leetCode.string.
//
//        Note:
//        The numbers can be arbitrarily large and are non-negative.
//        Converting the input first.leetCode.string to integer is NOT allowed.
//        You should NOT use internal library such as BigInteger.
    //字符串相乘
    //从右向左模拟乘法操作
public class MultiplyStrings_43 {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
    //查找第一个不为0的数
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();

}

    public static void main(String[] args) {
        System.out.println(multiply("9", "8"));
    }

}
