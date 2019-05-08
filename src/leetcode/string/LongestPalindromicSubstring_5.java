package leetCode.string;

/**
 * author： 张亚飞
 * time：2016/7/28  20:33
 */
//Given a first.leetCode.string S, find the longest palindromic substring in S.
//        You may assume that the maximum length of S is 1000,
//        and there exists one unique longest palindromic substring.
    //最长回文子串
public class LongestPalindromicSubstring_5 {
    //核心思想上，当增加一个字母依然是回文串的话，有两种可能，第一种是
    //从左边再增加一个字母，则字符串的长度增加2，还有一种是增加之后其本身又是回文
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
            if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }


}
