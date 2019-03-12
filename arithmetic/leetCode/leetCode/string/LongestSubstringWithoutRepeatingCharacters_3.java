package leetCode.string;

import java.util.HashMap;

/**
 * author： 张亚飞
 * time：2016/6/15  23:29
 */
//Given a leetCode.string, find the length of the longest substring without repeating characters.
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



    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "sdfs";
        s = s.substring(-1,3);
    }
}
