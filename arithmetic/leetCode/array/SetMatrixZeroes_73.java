package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/8/4  17:10
 */
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//        click to show follow up.
//
//        Follow up:
//        Did you use extra space?
//        A straight forward solution using O(mn) space is probably a bad idea.
//        A simple improvement uses O(m + n) space, but still not the best solution.
//        Could you devise a constant space solution?
    //给你一个m x n的矩阵，如果一行或一列中有一个元素为0，则把整行整列全设为0
public class SetMatrixZeroes_73 {

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        if (matrix.length == 0) return;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer i:
             rowSet) {
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix[i][j] = 0;
            }
        }

        for (Integer i:
                colSet) {
            for (int j = 0; j <matrix.length ; j++) {
                matrix[j][i] = 0;
            }
        }

    }

    public static void main(String[] args) {

    }
}
