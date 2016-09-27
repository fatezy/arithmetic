package Array;

/**
 * author： 张亚飞
 * time：2016/9/27  09:29
 */
/*Follow up for "Unique Paths":

        Now consider if some obstacles are added to the grids. How many unique paths would there be?

        An obstacle and empty space is marked as 1 and 0 respectively in the grid.

        For example,
        There is one obstacle in the middle of a 3x3 grid as illustrated below.

        [
        [0,0,0],
        [0,1,0],
        [0,0,0]
        ]
        The total number of unique paths is 2.*/
    //从左上到右下有多少种可能
public class UniquePathsII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] steps = new int[m][n];
        boolean flag = false;
        for (int i = 0; i <m ; i++) {
            if (obstacleGrid[i][0] == 1) flag = true;
            steps[i][0]=flag==true?0:1;
        }
        flag = false;
        for (int i = 0; i <n ; i++) {
            if (obstacleGrid[0][i] == 1) flag = true;
            steps[0][i]=flag==true?0:1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if (obstacleGrid[i][j] == 1) steps[i][j] = 0;
                else {
                    steps[i][j] = steps[i][j-1]+steps[i-1][j];
                }
            }
        }
        return steps[m-1][n-1];
    }

    public static void main(String[] args) {


    }
}
