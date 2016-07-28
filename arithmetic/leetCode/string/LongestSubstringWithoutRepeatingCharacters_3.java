package string;

import java.util.HashMap;

/**
 * author： 张亚飞
 * time：2016/6/15  23:29
 */
//Given a string, find the length of the longest substring without repeating characters.
//
//        Examples:
//
//        Given "abcabcbb", the answer is "abc", which the length is 3.
//
//        Given "bbbbb", the answer is "b", with the length of 1.
//
//        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
// must be a substring, "pwke" is a subsequence and not a substring.
    //找出给定字符串的最长的无重复字符的子串
public class LongestSubstringWithoutRepeatingCharacters_3 {


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


    public static void main(String[] args) {
        String s = "sdfs";
        s = s.substring(-1,3);
    }
}
