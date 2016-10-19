package hashmap;

/**
 * author： 张亚飞
 * time：2016/10/19  20:55
 */
/*Write a program to solve a Sudoku puzzle by filling the empty cells.

        Empty cells are indicated by the character '.'.*/
    //写一方法解决数独问题
    //经典的回溯问题
public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isVaild(board,i,j,c)){
                            board[i][j] = c;
                            if (solve(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }

                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }



    /**
     * 判断（i，j）填c是否可行
     * @param board
     * @param i
     * @param j
     * @param c
     * @return
     */
    public boolean isVaild(char[][] board,int i,int j,char c){
        //行是否重复
        for (int k = 0; k <9 ; k++) {
            if (board[i][k] == 'c')
                return false;
        }
        //列是否重复
        for (int k = 0; k <9 ; k++) {
            if (board[k][j] == 'c'){
                return false;
            }
        }
        //块是否重复
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;

    }
}
