package hashTable;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/5/12  21:36
 */
//Given an array of strings, group anagrams together.
//
//        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Return:
//
//        [
//        ["ate", "eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//        For the return value, each inner list's elements must follow the lexicographic order.
//        All inputs will be in lower-case.
    //找出所有由相同字母构成的字符串
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            String key = getkey(strs[i]);
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }

        }
        List<List<String>> results = new ArrayList<List<String>>();
        for (String str : map.keySet()){
            List<String> r = map.get(str);
            Collections.sort(r);
            results.add(r);

        }
        return results;
    }
    //获取key
    public String getkey(String string){
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);

    }
}
