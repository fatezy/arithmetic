package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/9/16  22:43
 */
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution.
//
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
    //给你一个数组和一个要获取的目标值，找出相加等于目标值的两个数的角标
//假设只有一种解法
public class TwoSum_1 {
    //一层遍历
    //运用hash解题
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }else {
                map.put(nums[i],i);
            }
        }

        return result;
    }


    public static void main(String[] args) {

    }
}
