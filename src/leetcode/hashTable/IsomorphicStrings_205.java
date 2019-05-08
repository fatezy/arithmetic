package leetCode.hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/5/12  19:57
 */
//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//        For example,
//        Given "egg", "add", return true.
//
//        Given "foo", "bar", return false.
//
//        Given "paper", "title", return true.
//
//        Note:
//        You may assume both s and t have the same length.
    //判断两个字符串是否同构，可以假设他们长度相同
public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(Integer i = 0; i < s1.length(); i++) {

            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
   @Test
    public void test(){
       isIsomorphic("abb","cdd");
   }

}
