package Backtracking;

import java.util.List;

/**
 * author： 张亚飞
 * time：2016/7/21  21:23
 */
//Given a 2D board and a word, find if the word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell
// may not be used more than once.
//
//        For example,
//        Given board =
//
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//        word = "ABCCED", -> returns true,
//        word = "SEE", -> returns true,
//        word = "ABCB", -> returns false.
//垂直或横向查找单词，但是同一个格子，不可以使用多次
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return true;
        }
        char c = word.charAt(0);
        char[] w = word.toCharArray();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j] == c){
                    if (exist(board,i,j,w,0)) return true;
                }
            }
        }
        return false;
    }



    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
    public static void main(String[] args) {

    }
}
