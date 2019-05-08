package leetCode.divideandConquer;

/**
 * author： 张亚飞
 * time：2016/5/15  11:26
 */
//Find the contiguous subarray within an first.leetCode.array (containing at least one number) which has the largest sum.
//
//        For example, given the first.leetCode.array [−2,1,−3,4,−1,2,1,−5,4],
//        the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    //找出最大子串和
    //如果加出来的和不小于0，从前向后不停的加

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max=nums[0],currentSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currentSum=currentSum<=0?nums[i]:currentSum+nums[i];
            max=Math.max(max,currentSum);
        }
        return max;
    }
}
