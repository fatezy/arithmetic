package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/10/7  19:03
 */
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
    //给你一个数组，求两数之和刚好为目标值
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
