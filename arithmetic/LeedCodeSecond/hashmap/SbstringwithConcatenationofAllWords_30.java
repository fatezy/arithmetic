package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/10/7  20:06
 */
/*You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in
 words exactly once and without any intervening characters.
        For example, given:
        s: "barfoothefoobarman"
        words: ["foo", "bar"]
        You should return the indices: [0,9].*/
    //给你一个字符串，和一个数组集合，找出所有的连续包含所有单词的位置
public class SbstringwithConcatenationofAllWords_30 {
    //加强了时间限制，一千是可以通过的
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length();
        for (int i = 0; i <words.length ; i++) {
            if (map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i],1);
            }
        }

        for (int i = 0; i <=s.length()-len*words.length ; i++) {
            Map<String,Integer> copy = new HashMap<>(map);

            for (int j = 0; j<words.length; j++) {
                String str = s.substring(i+j*len,i+j*len+len);
                if (copy.containsKey(str)){
                    if (copy.get(str)==1){
                        copy.remove(str);
                    }else {
                        copy.put(str,copy.get(str)-1);
                    }
                    if (copy.size()==0){
                        res.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
