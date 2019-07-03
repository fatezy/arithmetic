package 左程云;

public class 矩阵最短路径和 {
    public int minPath(int [][] matrix){
        return helper(matrix,0,0);
    }


    public int helper(int[][] martix,int i,int j){
        int m = martix.length-1;
        int n = martix[0].length-1;
        //如果是右下角节点
        if (i==m && j==n){
            return martix[i][j];
        }
        if (i== m){
            return  helper(martix,i,j+1)+martix[i][j];
        }

        if (j == n){
           return helper(martix,i+1,j)+martix[i][j];
        }

        int val1 = helper(martix,i+1,j)+martix[i][j];
        int val2 = helper(martix,i,j+1)+martix[i][j];
        return Math.min(val1,val2);
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        矩阵最短路径和 c = new 矩阵最短路径和();
        System.out.println(c.minPath(matrix));
    }
}
