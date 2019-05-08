package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/6  16:52
 */
//Given a first.leetCode.string S and a first.leetCode.string T, count the number of distinct subsequences of T in S.
//
//        A subsequence of a first.leetCode.string is a new first.leetCode.string which is formed from the original
// first.leetCode.string by deleting some (can be none) of the characters without disturbing the relative
// positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//        Here is an example:
//        S = "rabbbit", T = "rabbit"
//
//        Return 3.
//只可以通过删除字符串的方式得到另一个字符串
    //动态规划 动态规划，
// 定义dp[i][j]为字符串i变换到j的变换方法。
    //第72题的简化版
public class DistinctSubsequences_115 {
    public static int numDistinct(String S, String T) {
        if(S==null||T==null) {
            return 0;
        }
        if(S.length()<T.length()) {
            return 0;
        }
        //递推公式用的
        int [][] dp = new int[S.length()+1][T.length()+1];
        dp[0][0] = 1;
        //任意一个字符串变换成一个空串都只有一种变换方法
        for(int i=0;i<S.length();i++) {
            dp[i][0] = 1;
        }
        //递推公式
        for(int i=1;i<=S.length();i++) {
            for(int j=1;j<=T.length();j++) {
                //如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
                dp[i][j] = dp[i-1][j];   //删除
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1]; //不删除
                }
            }
        }
        return dp[S.length()][T.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("abcd", "e"));
    }
}
