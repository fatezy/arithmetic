package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/10/24  21:41
 */
/*Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving
        the order of characters. No two characters may map to the same character but a character
        may map to itself.

        For example,
        Given "egg", "add", return true.

        Given "foo", "bar", return false.

        Given "paper", "title", return true.*/
    //判断字符串是否同构
public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;
        if (s.length()<=1) return true;
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int length = charsS.length;
        Map<Character,Character>map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <charsS.length ; i++) {

            if (!map.containsKey(charsS[i])){
                if (!set.contains(charsT[i])) {
                    map.put(charsS[i], charsT[i]);
                    set.add(charsT[i]);
                }
            }else {
                if ( map.get(charsS[i])!=charsT[i]) {
                    return false;
                }
            }
        }
        if (map.containsKey(charsS[length-1])) return map.get(charsS[length-1])==charsT[length-1];
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("aa", "aa"));
    }
}
