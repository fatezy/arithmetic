package leetcode.bitManipulation;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/5/2  16:16
 */
//Given an first.leetCode.array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//        For example:
//
//        Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
    //给你一个数组，里面有两个数仅包含一次，请找出这两个数
    //因为^操作会使相同位全为0，故只要是为1的位一定两者不同

public class SingleNumbe3_260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }

        diff = Integer.highestOneBit(diff);

        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }

}
