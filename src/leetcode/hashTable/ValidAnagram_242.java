package leetcode.hashTable;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/4/27  15:54
 */
//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//        For example,
//        s = "anagram", t = "nagaram", return true.
//        s = "rat", t = "car", return false.
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
