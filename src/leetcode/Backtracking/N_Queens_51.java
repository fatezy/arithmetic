package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/8/3  21:16
 */
//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two
// queens attack each other.
//
//
//
//        Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//        Each solution contains a distinct board configuration of the n-queens' placement,
// where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//        For example,
//        There exist two distinct solutions to the 4-queens puzzle:
//
//        [
//        [".Q..",  // Solution 1
//        "...Q",
//        "Q...",
//        "..Q."],
//
//        ["..Q.",  // Solution 2
//        "Q...",
//        "...Q",
//        ".Q.."]
//        ]
    //n皇后问题，就是把n个皇后放在nxn的象棋框中，而不让她们互相攻击
    //皇后的攻击返回是斜对角，同一列，或同一行
public class N_Queens_51 {
    /**
     *
     * @param r 代表着放好已经放好的皇后的数目，同时也意味着是已经遍历到第几行
     * @param cols boolean数组，代表当前这一列是否含有皇后
     * @param d1 从右上到左下的第几条反斜线是否有值
     * @param d2 从右下到左上的第几条斜线是否有值
     * @param board 用于存储当前的解
     * @param res 用于保存所有的解
     */
    private static void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2,
                        String[] board, List<String[]> res) {
        if (r == board.length) res.add(board.clone());
        else {
            for (int c = 0; c < board.length; c++) {
                int id1 = r - c + board.length, id2 = 2*board.length - r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.'); row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true; d1[id1] = true; d2[id2] = true;
                    helper(r+1, cols, d1, d2, board, res);
                    cols[c] = false; d1[id1] = false; d2[id2] = false;
                }
            }
        }
    }

    public static List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n],
                new String[n], res);
        return res;
    }






//method 2
//    【解答】这个题目是比较经典的回溯法题目，很多教科书里面都有。根据国际象棋的规则，
// 这里要求任意两个皇后不能在同一行，不能在同一列，不能在同一条对角线上。使用一个int
// 数组来存放当前棋盘上皇后的状态，int[i]=j，表示第i行上，皇后放在第j列，这样天然避
// 免了在同一行情况的出现，也避免了使用二维数组来保存状态；但是不能在同一列和不能在同
// 一条对角线需要每次摆放一个皇后以后立马检查。
    public static List<String[]> solveNQueens2(int n) {
        List<String[]> list = new ArrayList<String[]>();
        solveNQueens(0, n, new int[n], list);
        return list;
    }

    private static void solveNQueens(int i, int n, int[] positions,
                              List<String[]> list) {
        if (i == n) {
            outputToList(n, positions, list);
        } else {
            for (int j = 0; j < n; j++) {
                positions[i] = j; // row: i, col: j
                if (validate(i, positions)) {
                    solveNQueens(i + 1, n, positions, list);
                }
            }
        }
    }

    private static void outputToList(int n, int[] positions, List<String[]> list) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < n; j++) {
                if (j == positions[i])
                    sb.append('Q');
                else
                    sb.append('.');
            }

            result[i] = sb.toString();
        }

        list.add(result);
    }

    private static boolean validate(int maxRow, int[] positions) {
        for (int i = 0; i < maxRow; i++) {
            if (positions[i] == positions[maxRow] // same column
                    || Math.abs(positions[i] - positions[maxRow]) == maxRow - i) // catercorner line
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);

    }
}
