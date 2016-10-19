package hashmap;

/**
 * author： 张亚飞
 * time：2016/10/10  15:03
 */
/*The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


        A partially filled sudoku which is valid.*/
    //数独
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        //分别代表行，列，块是否唯一
        //row[0][1]=true 代表第一块中含有1
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                int val = board[i][j] -'1';
                if (board[i][j] == '.'){
                    continue;
                }
                if (row[i][val] ||col[j][val] ||block[i - i % 3 + j / 3][val]){
                    return false;
                }
                row[i][val] =col[j][val] =block[i - i % 3 + j / 3][val]=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
