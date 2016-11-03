package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/11/3  15:17
 */
/*Given a pattern and a string str, find if str follows the same pattern.

        Here follow means a full match, such that there is a bijection between a letter
         in pattern and a non-empty word in str.

        Examples:
        pattern = "abba", str = "dog cat cat dog" should return true.
        pattern = "abba", str = "dog cat cat fish" should return false.
        pattern = "aaaa", str = "dog cat cat dog" should return false.
        pattern = "abba", str = "dog dog dog dog" should return false.*/
    //判断字符串是否遵守模板
public class WordPattern_190 {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chars.length!=strs.length) return false;
        Set<String> set = new HashSet<>();
        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i <chars.length ; i++) {
            if (map.containsKey(chars[i])){
                if (!map.get(chars[i]).equals(strs[i])) {
                    return false;
                }
            }else {
                if (!set.contains(strs[i])) {
                    map.put(chars[i], strs[i]);
                    set.add(strs[i]);
                }else {
                    return false;
                }
            }


        }
        return true;
    }
}
