package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/10/24  22:31
 */
//Given an array of integers and an integer k, find out whether there are two distinct indices
// i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
    //给你一个数组，判断是否存在其间相差小于k相同的数
public class ContainsDuplicateII_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i]) && i-map.get(nums[i])<=k)
                return true;
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums ={-1,-1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
