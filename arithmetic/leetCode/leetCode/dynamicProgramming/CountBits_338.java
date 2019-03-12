package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/4/25  10:45
 */
//Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an leetCode.array.
//
//        Example:
//        For num = 5 you should return [0,1,1,2,1,2].
    //题目释义:给你一哥菲副数，查找里面的每一个数中一的个数
//It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
//        Space complexity should be O(n).
    //时间复杂度控制欲O（n）
public class CountBits_338 {
    public int[] countBits(int num) {

        int[] dp = new  int[num+1];
        dp[0] = 0;
        for (int i = 0; i <dp.length ; i++) {
            if (i%2==1){
                dp[i] = dp[i/2]+1;
            }else {
                dp[i] = dp[i/2];
            }
        }

        return dp;
    }

}
