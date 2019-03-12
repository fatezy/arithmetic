package leetCode.hashTable;

/**
 * author： 张亚飞
 * time：2016/4/23  20:44
 */
//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//        The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    //数独小游戏，判断是否数独

public class IsValidSudoku_36 {

        public boolean isValidSudoku(char[][] board) {
            //三个布尔数组用于判断横，竖，方块内是否唯一
            boolean[][] row = new boolean[9][9];
            boolean[][] column = new boolean[9][9];
            boolean[][] block = new boolean[9][9];

            for(int i = 0;i<9;i++){
                for(int j=0;j<9;j++){
                    int c = board[i][j] - '1';
                    if(board[i][j]=='.'){
                        continue;
                    }
                    if(row[i][c]||column[j][c]||block[i - i % 3 + j / 3][c]){
                        return false;
                    }
                    row[i][c] = column[j][c] = block[i - i % 3 + j / 3][c] = true;
                }
            }
            return true;
        }


    public boolean isValidSudoku2(char[][] board) {
        //三个布尔数组用于判断横，竖，方块内是否唯一
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for(int i = 0;i<9;i++){
            for(int j=0;j<9;j++){
                int c = board[i][j] - '1';
                if(board[i][j]=='.'){
                    continue;
                }
                if(row[i][c]||column[j][c]||block[i/3*3+j/3][c]){
                    return false;
                }
                row[i][c] = column[j][c] = block[i/3*3+j/3][c] = true;
            }
        }
        return true;
    }


}
