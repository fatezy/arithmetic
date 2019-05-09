package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/8/4  12:10
 */
//Given an first.leetCode.array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//        You should pack your words in a first.leetCode.greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//        For the last line of text, it should be left justified and no extra space is inserted between words.
//
//        For example,
//        words: ["This", "is", "an", "example", "of", "text", "justification."]
//        L: 16.
//
//        Return the formatted lines as:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//题意：把一个集合的单词按照每行L个字符放，每行要两端对齐，如果空格不能均匀分布在所有间隔中，
// 那么左边的空格要多于右边的空格，最后一行靠左对齐。
public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }


        return lines;
    }
}
