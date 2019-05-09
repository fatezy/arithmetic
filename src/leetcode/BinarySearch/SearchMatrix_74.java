package leetcode.BinarySearch;

import org.junit.Test;

/**
 * author： 张亚飞
 * time：2016/5/15  14:41
 */
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        Given target = 3, return true.
//每一行第一个大于上面一行最后一个
public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int low = 0; int high = matrix.length * matrix[0].length-1;
        int mid;
        //行的位置
        int m = 0;
        //列的位子
        int n = 0;
        while (low <= high){
            mid = (low + high)>>1;
            m = mid/matrix[0].length;
            n = mid % matrix[0].length;
            if (target< matrix[m][n]){
                high = mid-1;
            }else {
                if (target > matrix[m][n]){
                    low = mid+1;
                }else {
                    return true;
                }
            }

        }
        return false;

    }
    @Test
    public void test(){
        int[][] a = {{1,2,3,4,5}};
        searchMatrix(a,2);
    }


}
