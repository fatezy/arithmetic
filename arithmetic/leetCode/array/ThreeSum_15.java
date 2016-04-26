package array;

import javafx.scene.effect.SepiaTone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/4/25  23:19
 */
//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//        Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//        The solution set must not contain duplicate triplets.
//        For example, given array S = {-1 0 1 2 -1 -4},
//
//        A solution set is:
//        (-1, 0, 1)
//        (-1, -1, 2)

    //给你一个数组，找出里面三数之和为0的所有组
    //本题重点考虑如何降低时间复杂度
public class ThreeSum_15 {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);
            int len = nums.length;
            for (int i=0;i<nums.length-2;i++){
                if (i>0&&nums[i]==nums[i-1]) continue;
                find(nums,i+1,len-1,nums[i]);
            }

        return ret;

    }
    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }



}
