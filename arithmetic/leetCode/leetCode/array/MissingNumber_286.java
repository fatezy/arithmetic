package leetCode.array;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/4/19  21:52
 */
//Given an leetCode.array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the leetCode.array.
//
//        For example,
//        Given nums = [0, 1, 3] return 2
public class MissingNumber_286 {
    public int missingNumber(int[] nums){



        int i=0;
        Arrays.sort(nums);
        for ( i=0;i<nums.length;i++){
            if (i!=nums[i])
                return i;
        }
        return i;

    }


    public static void main(String[] args) {
        int[] nums = {0};
        MissingNumber_286 missingNumber = new MissingNumber_286();
        System.out.println(missingNumber.missingNumber(nums));

    }
}
