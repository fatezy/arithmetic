package Array;

/**
 * author： 张亚飞
 * time：2016/9/28  21:19
 */
/*Given a 2D board and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell,
         where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

        For example,
        Given board =

        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]
        word = "ABCCED", -> returns true,
        word = "SEE", -> returns true,
        word = "ABCB", -> returns false.*/
    //二维数组里面查找单词
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i <board.length ; i++) {
        for (int j = 0; j <board[0].length ; j++) {
            if (board[i][j] == word.charAt(0)){
                if (backTrack(board,word,i,j,0)) return true;
            }

        }

    }
        return false;
    }


    public boolean backTrack(char[][] board,String word,int x,int y,int i){
        if (i == word.length()) return true;
        if (x<0||y<0||x>board.length-1||y>board[0].length-1) return false;
        if (word.charAt(i) != board[x][y]) return false;
        board[x][y] ^= 256;
        if (backTrack(board,word,x-1,y,i+1)||backTrack(board,word,x+1,y,i+1)||
                backTrack(board,word,x,y-1,i+1)||backTrack(board,word,x,y+1,i+1))
            return true;
        board[x][y] ^= 256;


        return false;
    }


}
