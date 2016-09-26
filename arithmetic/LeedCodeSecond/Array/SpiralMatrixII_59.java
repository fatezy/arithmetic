package Array;

/**
 * author： 张亚飞
 * time：2016/9/26  21:52
 */
/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

        For example,
        Given n = 3,

        You should return the following matrix:
        [
        [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]
        ]*/
    //旋转式填充矩阵
public class SpiralMatrixII_59 {
    public static int[][] generateMatrix(int n) {
        int top = 0; int down = n-1;
        int left = 0 ; int right = n-1;
        int [][] res = new int[n][n];
        int val = 1;
        while (top<=down&&left<=right){
            for (int i = left; i <=right ; i++) {
                res[top][i] = val++;
            }
            top++;
            for (int i = top; i <=down ; i++) {
                res[i][right] = val++;
            }
            right--;
            if (top<=down){
                for (int i = right; i >=left ; i--) {
                    res[down][i] = val++;
                }
            }
            down--;
            if (left<=right){
                for (int i = down; i >=top ; i--) {
                    res[i][left] = val++;
                }
            }
            left++;

        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
        System.out.println("ok");
    }

}
