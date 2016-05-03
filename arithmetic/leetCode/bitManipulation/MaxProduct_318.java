package bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/3  22:26
 */
//Given a string array words, find the maximum value of length(word[i]) * length(word[j])
// where the two words do not share common letters. You may assume that each word will contain
// only lower case letters. If no such two words exist, return 0.
//
//        Example 1:
//        Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
//        Return 16
//        The two words can be "abcw", "xtfn".
//
//        Example 2:
//        Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
//        Return 4
//        The two words can be "ab", "cd".
//
//        Example 3:
//        Given ["a", "aa", "aaa", "aaaa"]
//        Return 0
    //给你一组单词，找出他们中没有相同单词的两个单词，
// 求他们的长度之积，如果没有两个长度相同的单词，则返回·0
public class MaxProduct_318 {
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        //相当于一个32位的boolean数组，用于存放1-26个字母是否存在
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                //表明两个字符串没有相同的字符
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}
