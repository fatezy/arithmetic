package leetCode.TwoPoints;

/**
 * author： 张亚飞
 * time：2016/5/14  21:00
 */
//Given an leetCode.array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        For example, given the leetCode.array [2,3,1,2,4,3] and s = 7,
//        the subarray [4,3] has the minimal length under the problem constraint.
    //找出最短的子数组和大于目标值
    //滑动窗口法，最左边弄两个指针,一快一慢先后移动
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <1){
            return 0;
        }
        int start =0 , end = 0 , sum =0, min = Integer.MAX_VALUE;
        while (end <nums.length){
            sum += nums[end];
            while (sum>=s){
                min = Math.min(min,end-start+1);
                sum -= nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
