package leetCode.array;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/4/19  18:01
 */
//Given an leetCode.array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//        You may assume that the leetCode.array is non-empty and the majority element always exist in the leetCode.array.
    //找出出现n/2次以上的项
public class majorityElement_169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}
