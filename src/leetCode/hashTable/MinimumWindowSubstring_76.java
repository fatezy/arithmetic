package leetCode.hashTable;

/**
 * author： 张亚飞
 * time：2016/8/4  17:41
 */
//Given a first.leetCode.string S and a first.leetCode.string T, find the minimum window in S which will contain all the
// characters in T in complexity O(n).
//
//        For example,
//        S = "ADOBECODEBANC"
//        T = "ABC"
//        Minimum window is "BANC".
//给你一个字符串S和T，找出包含T中所有字母的S的最短子序列
public class MinimumWindowSubstring_76 {
    public static String minWindow(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < t_array.length; i++) // store t character and its count ----< means the lack number
            map[t_array[i]] ++;
        int count = t_array.length;
        int min_start = 0;

        // for those Characters t doesn't have, map[thisCharacter] are at most 0
        while(end < s_array.length)
        {
            if(map[s_array[end]] > 0)   // t has this character
            {
                count--;
            }
            map[s_array[end]] --;
            while(count == 0)   //window matches
            {
                if((end - start + 1) < min_length)
                {
                    min_length = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]] ++;     // start go left
                if(map[s_array[start]] > 0){    // remove a character which t has
                    count ++;           //Cause for those Characters t doesn't have, map[thisCharacter] are at most 0
                }
                start++;
            }
            end ++;

        }
        if( min_start+min_length > s_array.length)
            return "";
        return s.substring(min_start, min_start+min_length);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s,t);

    }
}
