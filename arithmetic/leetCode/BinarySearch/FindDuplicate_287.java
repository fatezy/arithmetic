package BinarySearch;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/5/1  15:58
 */
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//        Note:
//        You must not modify the array (assume the array is read only).
//        You must use only constant, O(1) extra space.
//        Your runtime complexity should be less than O(n2).
//        There is only one duplicate number in the array, but it could be repeated more than once.
    //给你一个数组有n+1个数，找出那个重复的数字，
    //数组只可以读
    //空间复杂度为1
    //时间复杂度小于O（n2）
    //只有一个重复数字，但可以重复多次
public class FindDuplicate_287 {
    //不符合要求的解法，
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==nums[i+1]){
                return nums[i];
            }

        }
        return 0;
    }

}
