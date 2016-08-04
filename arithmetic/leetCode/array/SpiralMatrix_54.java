package array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/8/3  21:32
 */
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//        For example,
//        Given the following matrix:
//
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        You should return [1,2,3,6,9,8,7,4,5].
    //给你一个矩阵，螺旋式遍历
public class SpiralMatrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        int top = 0; int left =0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;
        while (left<=right&&top<=down){
            for (int i = left; i <=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <=down ; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (down>=top) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
            }
            down--;
            if (left<=right) {
                for (int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;

        }
       return list;
    }


    public static void main(String[] args) {
        int[][] q ={
                {1,2}}
                ;
        System.out.println(spiralOrder(q));
    }


}
