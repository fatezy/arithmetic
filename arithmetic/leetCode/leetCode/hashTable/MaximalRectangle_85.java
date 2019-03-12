package leetCode.hashTable;

/**
 * author： 张亚飞
 * time：2016/8/5  21:34
 */
//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 6.
    //找出不包含0的面积最大的矩阵
public class MaximalRectangle_85 {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        //用于存储降维之后的矩阵
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (i==0){
                    if (matrix[i][j] == '0'){
                        tempMatrix[i][j] =0;
                    }else {
                        tempMatrix[i][j] = 1;
                    }
                    continue;
                }
                if (matrix[i][j] =='1'){
                    tempMatrix[i][j] = tempMatrix[i-1][j]+1;
                }
            }
        }
            int max = 0;
        for (int i = 0; i <tempMatrix.length ; i++) {
            max = Math.max(max,findMaxArea(tempMatrix[i]));
        }
        return max;
    }

    /**
     * 给你一个柱状图，找出可以围成矩形的最大面积，即84题
     * @param height
     * @return
     */
    private static int findMaxArea(int[] height){
        int res = 0;
        for (int i = 0; i <height.length ; i++) {
            int h = height[i];
            for (int j = i; j <height.length ; j++) {
                if (height[j]<h) {
                    h = height[j];
                }
                res = Math.max(res,(j-i+1)*h);
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }

    }



