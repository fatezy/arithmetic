package Array;

/**
 * author： 张亚飞
 * time：2016/9/24  15:33
 */
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

        For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
        the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/
    //找出最大的连续和最大的子序列
    //动态规划
    //需维护两个最大值
    //一个是全局的，一个是当前的
public class MaximumSuarray_53 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = 0;
        for (int i = 0; i <nums.length ; i++) {
            currSum=currSum>=0?nums[i]+currSum:nums[i];
            if (currSum>sum){
                sum = currSum;
            }
        }

        return sum;
    }


    public static void main(String[] args) {

    }
}
