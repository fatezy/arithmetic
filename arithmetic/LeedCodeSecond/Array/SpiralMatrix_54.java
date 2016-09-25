package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/25  21:27
 */
/*Given a matrix of m x n elements (m rows, n columns),
return all elements of the matrix in spiral order.

        For example,
        Given the following matrix:

        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        You should return [1,2,3,6,9,8,7,4,5].*/
//以螺旋的方式遍历二维数组
public class SpiralMatrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int top = 0; int left =0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;
        while (left<=right&&top<=down){
            for (int i = left; i <=right ; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <=down ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (down>=top) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            down--;
            if (right>=left) {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] num = {{2,3}};
        System.out.println(spiralOrder(num));
    }
}
