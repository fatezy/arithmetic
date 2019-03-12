package leetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/4/27  15:38
 */
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        For example, given n = 3, a solution set is:
//
//        "((()))", "(()())", "(())()", "()(())", "()()()"
    //括号匹配
    //写过的左括号次数必须小于n，那就可以写左括号；
//写过的右括号次数必须小于n，并且也小于左括号次数，那就可以写右括号。
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        append(n, 0, 0, "", list);
        return list;
    }
    public void append(int n, int left, int right, String s, List<String> list) {
        if (left==n && right==n) {
            list.add(s);
            return;
        }

        if (left<n) {
            append(n, left+1, right, s+'(', list);
        }

        if (right<n && left>right) {
            append(n, left, right+1, s+')', list);
        }
    }


    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = n - 1; i >= 0; i--) {
                List<String> insertSub = generateParenthesis(i);
                List<String> tailSub = generateParenthesis(n - 1 - i);
                for (String insert : insertSub) {
                    for (String tail : tailSub) {
                        result.add("(" + insert + ")" + tail);
                    }
                }

            }
        }
        return result;
    }

}
