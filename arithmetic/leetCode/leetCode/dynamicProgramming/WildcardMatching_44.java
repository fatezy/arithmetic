package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/3  17:09
 */
//Implement wildcard pattern matching with support for '?' and '*'.
//
//        '?' Matches any single character.
//        '*' Matches any sequence of characters (including the empty sequence).
//
//        The matching should cover the entire input leetCode.string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "*") → true
//        isMatch("aa", "a*") → true
//        isMatch("ab", "?*") → true
//        isMatch("aab", "c*a*b") → false
    //实现简单的正则匹配
public class WildcardMatching_44 {
    public static boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                    match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }

    public static void main(String[] args) {
        isMatch("aa","a*");

    }
}
