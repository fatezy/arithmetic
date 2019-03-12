package leetCode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/4/26  22:41
 */
//Write a function that takes a leetCode.string as input and reverse only the vowels of a leetCode.string.
//
//        Example 1:
//        Given s = "hello", return "holle".
//
//        Example 2:
//        Given s = "leetcode", return "leotcede".
//扭转元音字母即（a,o,e,i,u）
public class ReverseVowelsofaString_345 {
    public String reverseVowels(String s) {
        Map<String,String> map = new HashMap<>();
        map.put("a","a");  map.put("A","A");
        map.put("o","o");  map.put("O","O");
        map.put("e","e");  map.put("E","E");
        map.put("i","i");  map.put("I","I");
        map.put("u","u");   map.put("U","U");
        int left=0; int right =s.length()-1;
        char temp ='1';
        char[] ret= s.toCharArray();
        while (left<right){
            while (left<right&&!map.containsKey(s.charAt(left)+"")){
                left++;
            }
            while (left<right&&!map.containsKey(s.charAt(right)+"")){
                right--;
            }
            if (left<right){
                temp = s.charAt(left);
                ret[left] = ret[right];
                ret[right] = temp;
                left++;
                right--;

            }
        }
        return  String.valueOf(ret);
    }
}
