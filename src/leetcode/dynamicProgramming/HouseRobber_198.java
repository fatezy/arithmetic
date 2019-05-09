package leetcode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/6/12  17:08
 */
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
// it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum
// amount of money you can rob tonight without alerting the police.
    //我是一个抢劫犯，不可以抢相邻的房子，如何抢到最多的钱
public class HouseRobber_198 {
    public static int rob(int[] num) {
        //dp[i][1]代表抢当前的屋子，dp[i][0]代表不抢
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }


    public static void main(String[] args) {

    }
}
