package leetcode.array;

/**
 * author： 张亚飞
 * time：2016/5/25  22:35
 */
//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        Follow up:
//        Could you do this in-place?
//        旋转90度
//        假设该数组为 a[n][n],
//        其中的一个元素为 a[x][y],
//        顺时针旋转90度后,该元素的坐标为 a[y][n-x]
//可以先右斜线对折，再沿着中轴先对折
public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

}
