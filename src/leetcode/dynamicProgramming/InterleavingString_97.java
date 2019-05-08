package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/6  15:17
 */
//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//        For example,
//        Given:
//        s1 = "aabcc",
//        s2 = "dbbca",
//
//        When s3 = "aadbbcbcac", return true.
//        When s3 = "aadbbbaccc", return false.
    //判断s3是否是由s1,s2交织而成
    //动态规划
public class InterleavingString_97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int index = 0;
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean [][] res = new boolean[s1.length()+1][s2.length()+1];
        //初始化res[i][0],即第一列数据
        res[0][0] = true;
        for (int i = 0; i <s1.length() ; i++) {
            if (s1.charAt(i) != s3.charAt(i)){
                break;
            }
            res[i+1][0] =  true;
        }
        //初始化第一行数据
        for (int i = 0; i <s2.length() ; i++) {
            if (s2.charAt(i) != s3.charAt(i)){
                break;
            }
            res[0][i+1] =  true;
        }

        for (int i = 0; i <s1.length() ; i++) {
            for (int j = 0; j <s2.length(); j++) {
                char cs1 = s1.charAt(i);
                char cs2 = s2.charAt(j);
                char cs3 = s3.charAt(i+j+1);
                if (cs1 == cs3 && res[i][j+1]){
                     res[i+1][j+1] = true;

                }

                if (cs2 == cs3 && res[i+1][j]){
                    res[i+1][j+1] = true;
                }
            }
        }

        return res[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
