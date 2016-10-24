package hashmap;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/10/24  23:05
 */
/*Given two strings s and t, write a function to determine if t is an anagram of s.

        For example,
        s = "anagram", t = "nagaram", return true.
        s = "rat", t = "car", return false.

        Note:
        You may assume the string contains only lowercase alphabets.

        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?*/
    //判断t是不是s的一个排列
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
