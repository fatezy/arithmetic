package Array;

/**
 * author： 张亚飞
 * time：2016/9/17  15:54
 */
/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note: The solution set must not contain duplicate triplets.

        For example, given array S = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个数组， 找出所有的三数之和为0的解
 */
public class ThreeSum_15 {
    //通过固定一个点及转化为有序数组，
    // 来降低维度，转化为求两个数相加和为0的题
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            find(nums,i+1,len-1,nums[i],lists);
        }

        return lists;
    }
//双指针法，从两端向中间倒逼，找出目标结果
    public static void find(int[] nums,int begin,int end,int target,List<List<Integer>> lists){
        int l = begin, r = end;
        while (l<r){
            if (nums[l]+nums[r]+target == 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                list.add(target);
                lists.add(list);
                while (l < r && nums[l] == nums[l+1]) l++;
                while (l < r && nums[r] == nums[r-1]) r--;
                l++;
                r--;
            }else if (nums[l]+nums[r]+target < 0){
                l++;
            }else {
                r--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }
}
