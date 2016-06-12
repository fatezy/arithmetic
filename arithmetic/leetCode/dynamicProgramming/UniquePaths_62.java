package dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/6/12  14:27
 */
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time. The robot is trying to
// reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        How many possible unique paths are there?
    //一个机器人只能向下或向右运动，从最左上角开始一直运动到最右下角，求一共有多少种运动的方式
public class UniquePaths_62 {
    //精度影响，故用double
    //这种解法用的是单纯的数学解法
    public static int uniquePaths(int m, int n) {
        double result = 1;
        for (int i = 0; i <m-1 ; i++) {
                result=result*n/(i+1);
                 n++;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
}
