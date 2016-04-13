package hashTableh;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/4/23  20:09
 */
//Given an array of integers, every element appears twice except for one. Find that single one.
    //找到没有重复的那个数
public class SingleNumber_136 {
    //该方法超时，叫你烂
    public int singleNumber(int[] nums) {
         Arrays.sort(nums);
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        for (int i = 0; i <nums.length ; i=i+2) {
            if (nums[i]!=nums[i+1]){
                return nums[i];
            }


        }

       return 0;
    }

    //运算符逆天版
    //转化为二进制，相同返回0，不同返回1
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

}
