package dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/7/21  19:51
 */
//Given a m x n grid filled with non-negative numbers, find a path from top left
//        to bottom right which minimizes the sum of all numbers along its path.
    //给你一个mxn的矩阵，里面储存了一些非零的数据，
    //求从左上角，到右下角的最短步数和


    //极为典型的动态规划问题
public class MinimumPathSum_64 {


    //非递归解法
    public static int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (i==0&&j==0){
                    sum[i][j] = grid[i][j];
                }else if (i==0&&j!=0){
                    sum[i][j] = sum[i][j-1] + grid[i][j];
                }else if (i !=0 && j==0){
                    sum[i][j] = sum[i-1][j] + grid[i][j];
                }else {
                    sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
                }

            }

        }

       return sum[grid.length-1][grid[0].length-1];
    }

//递归解法
//递归超时
    public static int minPathSum3(int[][] grid) {

        return minPath(grid.length-1,grid[0].length-1,grid);

    }

    public static int minPath(int i,int j,int[][] grid){
        if (i==0 && j == 0){
            return grid[0][0];
        }

        if (i== -1|| j== -1 ){
            return Integer.MAX_VALUE;
        }

        return Math.min(minPath(i-1,j,grid),minPath(i,j-1,grid)) + grid[i][j];


    }


    public static int minPathSum2(int[][] grid) {
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
                int[][] a = {{5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1},
               {1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0},
               {2,8,3,3,1,6,1,4,9,0,9,2,3,3,3,8,4},
               {3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9},
               {3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4},
               {8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1},
               {7,1,0,4,7,8,4,6,4,2,1,3,7,8,3,5,4},
               {3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7},
               {8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4},
                {3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4},
                {5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6},
                {5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7},
                {9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9},
                {7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8}};

        System.out.println(minPathSum3(a));


    }

}





