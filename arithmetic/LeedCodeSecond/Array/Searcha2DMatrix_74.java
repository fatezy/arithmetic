package Array;

/**
 * author： 张亚飞
 * time：2016/9/27  20:51
 */
/*Write an efficient algorithm that searches for a value in an m x n matrix.
 This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
        For example,

        Consider the following matrix:

        [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        Given target = 3, return true.*/
    //二维数组中查找
public class Searcha2DMatrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; int n = matrix[0].length;
        int i = 0; int j = n-1;
        while (i<m&&j>=0){
            if (matrix[i][j] == target) return true;
            if (matrix[i][j]<target) i++;
           else if (matrix[i][j] > target) j--;
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] num = {{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(searchMatrix(num, 16));
    }
}
