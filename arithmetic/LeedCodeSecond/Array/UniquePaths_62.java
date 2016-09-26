package Array;

/**
 * author： 张亚飞
 * time：2016/9/26  22:11
 */
/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time. The robot is trying to
        reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).*/
    //判断有多少种不同的走法
    //经典的动态规划题
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        for (int i = 0; i <m ; i++) {
            steps[i][0] = 1;
        }
        for (int i = 0; i <n ; i++) {
            steps[0][i] = 1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                steps[i][j] = steps[i-1][j]+steps[i][j-1];
            }
        }
        return steps[m-1][n-1];
    }


    public static void main(String[] args) {

    }
}
