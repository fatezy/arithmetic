package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/17  16:26
 */
/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

        For example, given array S = {-1 2 1 -4}, and target = 1.

        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
    //找出三数之和，最接近目标数的值
public class ThreeSumClosest_16 {

    static int closeSum = Integer.MAX_VALUE;
    static int closeDis = Integer.MAX_VALUE;
    public static int threeSumClosest(int[] nums, int target) {
        closeSum = Integer.MAX_VALUE;
        closeDis = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0;i<nums.length-2;i++){

            find(nums,i+1,len-1,nums[i],target);
        }

        return closeSum;
    }

    public  static void find(int[] num, int begin, int end, int val,int target){
        int l = begin, r = end;
        while (l < r) {
            int sum = num[l] + num[r] + val;
            if (num[l] + num[r] + val == target) {
                closeDis = 0;
                closeSum = sum;
                return;
            } else if (num[l] + num[r] + val < target) {
                    if (target - sum <closeDis){
                        closeDis = target - sum;
                        closeSum = sum;
                    }
                l++;
            } else {
                if (sum - target <closeDis){
                    closeDis = sum - target;
                    closeSum = sum;
                }
                r--;
            }
        }

    }



    public static void main(String[] args) {
        int[] nums = {4,4,-1,-4};
        System.out.println(threeSumClosest(nums, -1));
    }
}
