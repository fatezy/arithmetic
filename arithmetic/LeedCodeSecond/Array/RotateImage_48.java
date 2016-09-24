package Array;

/**
 * author： 张亚飞
 * time：2016/9/24  15:18
 */
/*You are given an n x n 2D matrix representing an image.

        Rotate the image by 90 degrees (clockwise).

        Follow up:
        Could you do this in-place?*/
    //将矩阵右转90度
    //即相当于先右斜线对折
    //再沿中线对折
public class RotateImage_48 {
    public static void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;

            }

        }
    }


    public static void main(String[] args) {
        int[][] a ={{1,2},{3,4}};
        rotate(a);
    }
}
