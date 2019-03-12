package leetCode.bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/3  16:35
 */
//Given an leetCode.array of integers, every element appears three times except for one. Find that single one.
   //每个数出现三次，仅有一个数出现了一次，请找出来
    //并且要求其时间复杂度为O（n），，空间复杂度为O（1）
public class SingleNumber2_137 {

    public static int singleNumber2(int[] nums) {
        int len = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
}
