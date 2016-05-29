package Backtracking;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/5/28  17:05
 */
//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//        Note:
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        For example,
//        If nums = [1,2,2], a solution is:
//
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]
    //求出所有的子集，不存在副本子串
public class SubsetsII_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = (int) Math.pow(2,nums.length) - 1;
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i <=len ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <nums.length ; j++) {
                //看看是否包含nums[j]
                if (((i>>j)&1) == 1 ){
                    list.add(nums[j]);
                }
            }
            if (set.add(list)) {
                lists.add(list);
            }
        }
        return lists;
    }




}
