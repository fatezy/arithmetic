package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/6/12  16:48
 */
//Follow up for "Unique Paths":
//
//        Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//        An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//        For example,
//        There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//        [
//        [0,0,0],
//        [0,1,0],
//        [0,0,0]
//        ]
//        The total number of unique paths is 2.
    //给你一个相关的图，1代表障碍，0代表非障碍
    //求到达终点，有多少种路径
    //典型的动归背包问题
public class UniquePathsII_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] methods = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i <obstacleGrid.length ; i++) {
            for (int j = 0; j <obstacleGrid[0].length ; j++) {
                if (obstacleGrid[i][j] == 1){
                    methods[i][j] = Integer.MIN_VALUE;
                }else if (i==0&&j==0){
                    methods[0][0] = 1;
                }else if (i==0&&j!=0){
                    methods[i][j] = methods[i][j-1];
                }else if (i!=0&&j==0){
                    methods[i][j] = methods[i-1][j];
                }else if (methods[i-1][j]<-1 && methods[i][j-1]>-1){
                    methods[i][j] = methods[i][j-1];
                }else if (methods[i-1][j]>-1 && methods[i][j-1]<-1){
                    methods[i][j] = methods[i-1][j];
                }else {
                    methods[i][j] = methods[i-1][j]+methods[i][j-1];
                }

            }
        }
        if (methods[obstacleGrid.length-1][obstacleGrid[0].length-1]>-1)
        return methods[obstacleGrid.length-1][obstacleGrid[0].length-1];
        else
            return 0;

    }


    public static void main(String[] args) {

        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));

    }
}
