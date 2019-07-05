package 左程云;

import org.omg.CORBA.MARSHAL;

public class 最大子序和 {


//    dp[i] = max{num[i], dp[i - 1] + num[i]}
public int maxSubArray(int[] nums) {
    int len = nums.length;
    if (len == 0) {
        return 0;
    }
    int[] dp = new int[len];
    dp[0] = nums[0];
    for (int i = 1; i < len; i++) {
        dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    }

    int res = dp[0];
    for (int i = 1; i < len; i++) {
        res = Math.max(res,dp[i]);
    }
    return res;
}

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        helper(nums,length-1,dp);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <dp.length ; i++) {
            if (dp[i]>res){
                res = dp[i];
            }
        }

        return res;
    }

    //dp[i] 代表0到i的最大值
    public int  helper(int[] nums,int i,int[] dp){
        if (i==0){
            dp[0] = nums[0];
            return nums[0];
        }
        dp[i-1] = helper(nums,i-1,dp);
        dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
      return dp[i];

    }


    public static void main(String[] args) {
        int[] an = {-2,1,-3,4,-1,2,1,-5,4};
        最大子序和 main = new 最大子序和();
        main.maxSubArray2(an);

    }



}
