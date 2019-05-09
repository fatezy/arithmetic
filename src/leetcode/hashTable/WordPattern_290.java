package leetcode.hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/5/12  22:07
 */
//Given a pattern and a first.leetCode.string str, find if str follows the same pattern.
//
//        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//        Examples:
//        pattern = "abba", str = "dog cat cat dog" should return true.
//        pattern = "abba", str = "dog cat cat fish" should return false.
//        pattern = "aaaa", str = "dog cat cat dog" should return false.
//        pattern = "abba", str = "dog dog dog dog" should return false.
//        Notes:
//        You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
    //判断是否属于某种类型
    //奇怪的测试用例，最后一个用例没过
public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();
        String[] strings = str.split(" ");
        if (strings.length!= pattern.length())
           return false;

        for (int i = 0; i <pattern.length(); i++) {
            if (patternMap.put(pattern.charAt(i),i) != strMap.put(strings[i],i)){
                return false;
            }

        }
        return true;

    }
    @Test
    public void test(){
        wordPattern("abba","abba");

    }

}
