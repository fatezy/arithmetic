package interview;

import java.util.LinkedList;

/**
 * Created by 张亚飞 on 2019/7/18.
 */
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        // 二维数组问题

        int islands_num = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j] == '1'){ // 当前元素为1时，才进行后续判断
                    islands_num ++;
                    grid = dfs(i,j,grid);
                }
            }
        }

        return islands_num;
    }

    public static char[][] dfs(int x, int y, char[][] grid){
        if(0<=x && x<grid.length && 0<=y && y<grid[x].length){
            if(grid[x][y] == '1'){
                grid[x][y] = '0';
                // 将上下左右的元素进行判断
                dfs(x-1, y, grid);
                dfs(x+1, y, grid);
                dfs(x, y-1, grid);
                dfs(x, y+1, grid);
            }
        }
        return grid;
    }

    public int numIslands2(char[][] grid) {
        // 二维数组问题
        int islands_num = 0;
        boolean[][] dp = new boolean[grid.length][grid[0].length];


        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if (dfs2(i,j,grid,dp)){
                    islands_num++;
                }
            }
        }

        return islands_num;
    }


    public static boolean dfs2(int i,int j,char[][] grid,boolean[][] dp){
        if(0<=i && i<grid.length && 0<=j&& j<grid[i].length) {
            if (dp[i][j] == true || grid[i][j] == '0'){
                dp[i][j] = true;
                return false;
            }
            else {
                dp[i][j] = true;
                boolean a = dfs2(i - 1, j, grid, dp);
                boolean b = dfs2(i + 1, j, grid, dp);
                boolean c = dfs2(i, j - 1, grid, dp);
                boolean d = dfs2(i, j + 1, grid, dp);
                boolean e = grid[i][j] == '1';
//                return a||b||c||d||e;          画蛇添足
                return true;
            }
        }
        return false;
    }





    public int numIslands3(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x*m+y;
        queue.offer(code);
        while(!queue.isEmpty())
        {
            code = queue.poll();
            int i = code/m;
            int j = code%m;
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i-1)*m+j);
                grid[i-1][j]='0';
            }
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {
                queue.offer((i+1)*m+j);
                grid[i+1][j]='0';
            }
            if(j>0 && grid[i][j-1]=='1')  //left
            {
                queue.offer(i*m+j-1);
                grid[i][j-1]='0';
            }
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {
                queue.offer(i*m+j+1);
                grid[i][j+1]='0';
            }
        }
    }





    public static void main(String[] args) {
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        岛屿数量 c = new 岛屿数量();
        System.out.println(c.numIslands2(chars));
    }
}

