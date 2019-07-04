package 左程云;

import java.util.ArrayList;
import java.util.List;

public class 矩阵最短路径和 {

    public int minPath(int [][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(matrix,0,0,dp);
    }


    public int helper(int[][] martix,int i,int j,int[][] dp){
        int m = martix.length-1;
        int n = martix[0].length-1;
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        //如果是右下角节点
        if (i==m && j==n){
            dp[i][j] = martix[i][j];
            return dp[i][j];
        }
        if (i== m){
            dp[i][j] = helper(martix,i,j+1,dp)+martix[i][j];
            return  dp[i][j];
        }

        if (j == n){
            dp[i][j] = helper(martix,i+1,j,dp)+martix[i][j];
           return dp[i][j];
        }

        int val1 = helper(martix,i+1,j,dp)+martix[i][j];
        int val2 = helper(martix,i,j+1,dp)+martix[i][j];
        dp[i][j] = Math.min(val1,val2);
        return dp[i][j];
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        矩阵最短路径和 c = new 矩阵最短路径和();
        System.out.println(c.minPath(matrix));
    }
}
