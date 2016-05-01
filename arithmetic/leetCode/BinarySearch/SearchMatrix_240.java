package BinarySearch;

import org.junit.Test;

/**
 * author： 张亚飞
 * time：2016/5/1  15:06
 */
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        Given target = 5, return true.
//
//        Given target = 20, return false.
    //给你一个二维数组，查找里面是否包含要查找的数，该数组每行每列均有序
public class SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null){
            return false;
        }
        //行数
        int m = matrix.length;
        //列数
        int n = matrix[0].length;
        for (int i = 0; i <m ; i++) {
          if ( bSearch(i,n-1,target,matrix))
              return true;

        }
        return false;

    }

    public boolean bSearch(int m,int n,int target , int[][] nums) {
        int low = 0; int high = n;
        int mid;
        while (low<=high){
            mid = (low + high)>>1;
            if (nums[m][mid]>target){
                high = mid - 1;

            }else if (nums[m][mid]<target){
                low = mid +1;

            }else return true;
        }
        return false;

    }


    @Test
    public void test(){
        int[][] a = {{1,2,3,4,5}};
        searchMatrix(a,2);
    }


}
