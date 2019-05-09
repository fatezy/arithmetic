package leetcode.array;

/**
 * author： 张亚飞
 * time：2016/4/25  11:11
 */
//Given a non-negative number represented as an first.leetCode.array of digits, plus one to the number.
//
//        The digits are stored such that the most significant digit is at the head of the list.
    //给你一个数字，转化数组储存，每一位都储存，加一后返回这个数组
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        for (int i =digits.length-1;i>=0;i--){
            if (digits[i]>=10&&i!=0){
                digits[i]=0;
                digits[i-1]++;
            }
            if (digits[i]>=10&&i==0){
                digits[i]=0;
                int[] arr = new int[digits.length+1];
                arr[0]=1;
                return arr;
            }

        }

        return digits;
    }
}
