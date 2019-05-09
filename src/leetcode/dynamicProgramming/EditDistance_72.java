package leetcode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/4  16:35
 */
//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//        You have the following 3 operations permitted on a word:
//
//        a) Insert a character
//        b) Delete a character
//        c) Replace a character
    //把一个单词转换为另外一个单词，最少需要多少步

/**
 * f(i,j)代表第一个单词的前i个字母，转换为第二个单词的前j个字母共需多少步
 * case1：word1[i] == word[j]  f(i,j) = f(i-1,j-1)
 * case2: word1[i] != word[j]  f(i,j） = 1+min{f(i,j-1),f(i-1,j),f(i-1,j-1)}//插，删，改
 * base case: f(0, k) = f(k, 0) = k
 */

public class EditDistance_72 {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][] costs = new int[len1+1][len2+1];
        for (int i = 0; i <=len1 ; i++) {
            costs[i][0] = i;
        }
        for (int i = 0; i <=len2 ; i++) {
            costs[0][i] = i;
        }
        for (int i = 0; i <len1 ; i++) {
            for (int j = 0; j <len2 ; j++) {
                if (word1.charAt(i) == word2.charAt(j)){
                    costs[i+1][j+1] = costs[i][j];
                }else {
                    int a = costs[i][j];
                    int b = costs[i][j + 1];
                    int c = costs[i + 1][j];
                    costs[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    costs[i + 1][j + 1]++;
                }
            }

        }


        return costs[len1][len2];
    }


    public static void main(String[] args) {
        minDistance("","a");
    }
}
