package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/9/27  20:34
 */
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    //给你一个m*n的矩阵，把整行整列设为0
public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setCol = new HashSet<>();
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j] == 0){
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }

        for (Integer val:
             setRow) {
            for (int i = 0; i <matrix[0].length ; i++) {
                matrix[val][i] = 0;
            }
        }

        for (Integer val:
                setCol) {
            for (int i = 0; i <matrix.length ; i++) {
                matrix[i][val] = 0;
            }
        }

    }

    public static void main(String[] args) {

    }
}
