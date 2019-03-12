package leetCode.array;

/**
 * author： 张亚飞
 * time：2016/5/25  23:00
 */
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//        For example,
//        Given n = 3,
//
//        You should return the following matrix:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]
    //螺旋式打印矩阵

public class SpiralMatrixII_59{


    public static int[][] generateMatrix2(int n) {
    int[][] ret = new int[n][n];
    int left = 0,top = 0;
    int right = n -1,down = n - 1;
    int count = 1;
    while (left <= right) {
        for (int j = left; j <= right; j ++) {
            ret[top][j] = count++;
        }
        top ++;
        for (int i = top; i <= down; i ++) {
            ret[i][right] = count ++;
        }
        right --;
        for (int j = right; j >= left; j --) {
            ret[down][j] = count ++;
        }
        down --;
        for (int i = down; i >= top; i --) {
            ret[i][left] = count ++;
        }
        left ++;
    }
    return ret;
}
}
