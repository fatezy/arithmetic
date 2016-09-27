package Array;

/**
 * author： 张亚飞
 * time：2016/9/27  19:05
 */
/*Given a m x n grid filled with non-negative numbers, find a path from top left to
        bottom right which minimizes the sum of all numbers along its path.*/

public class MinimumPathSum_64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i <m; i++) {
            sum[i][0] +=sum[i-1][0]+ grid[i][0];
        }
        for (int i = 1; i <n ; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                int min = Math.min(sum[i-1][j],sum[i][j-1]);
                sum[i][j] = min+grid[i][j];
            }

        }
        return sum[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] nums ={{1,2},{2,1}};
        System.out.println(minPathSum(nums));

    }
}
