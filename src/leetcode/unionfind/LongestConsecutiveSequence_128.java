package leetCode.unionfind;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/9/6  19:36
 */
//Given an unsorted first.leetCode.array of integers, find the length of the longest consecutive elements sequence.
//
//        For example,
//        Given [100, 4, 200, 1, 3, 2],
//        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//        Your algorithm should run in O(n) complexity.
    //给你一个无序数组，找出其中最长的连续性数组
    //并查集

public class LongestConsecutiveSequence_128 {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int tempVal = nums[0];
         int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]-tempVal == 1) {
                count ++;
                tempVal = nums[i];
                if (i == nums.length - 1&&count>res){
                    res = count;
                }
            }else {
                if (count>res){
                res = count;
                }
                if (nums[i]-tempVal==0) continue;

                count = 0;
                tempVal = nums[i];
            }
        }
        return res+1;
    }




    public static void main(String[] args) {
        int[] nums = {-1,0,0};
        System.out.println(longestConsecutive(nums));

    }

}
