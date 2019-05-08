package leetCode.string;

import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/7/25  21:29
 */
//Given a first.leetCode.string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".
    //判断字符串s是否可以被划分为多个字典中的单词
    //dp经典背包问题
public class WordBreak_139 {


    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {

    }


    }




