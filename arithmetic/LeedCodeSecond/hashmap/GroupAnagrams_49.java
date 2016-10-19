package hashmap;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/10/19  22:28
 */
/*Given an array of strings, group anagrams together.

        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Return:

        [
        ["ate", "eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]*/
//单词分组，按照颠倒字母相同的一组
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            String val = getKey(strs[i]);
            if (map.containsKey(val)) {
                map.get(val).add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(val,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String str:map.keySet()){
            List<String> r = map.get(str);
            Collections.sort(r);
            res.add(r);
        }
        return res;
    }

    public String getKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    public static void main(String[] args) {

    }
}
