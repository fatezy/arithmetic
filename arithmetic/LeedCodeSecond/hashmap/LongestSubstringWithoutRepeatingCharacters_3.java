package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/10/7  19:11
 */
/*Given a string, find the length of the longest substring without repeating characters.

        Examples:

        Given "abcabcbb", the answer is "abc", which the length is 3.

        Given "bbbbb", the answer is "b", with the length of 1.

        Given "pwwkew", the answer is "wke", with the length of 3. Note that the
        answer must be a substring, "pwke" is a subsequence and not a substring.*/
    //找出最长的无重复的字串
    //经典的双指针法
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0,j=0; i<s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){
                j =Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
