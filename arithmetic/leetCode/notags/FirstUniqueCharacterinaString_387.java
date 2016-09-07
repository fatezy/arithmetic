package notags;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/9/6  20:17
 */
//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.
    //找出第一个不重复字母的位置
public class FirstUniqueCharacterinaString_387 {
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.replace(chars[i],map.get(chars[i])+1);
            }
        }
        int res = -1;
        for (int i = 0; i <s.length() ; i++) {
            if (map.get(chars[i]) == 1) {
                res = i;
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
