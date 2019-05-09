package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/6/3  16:13
 */

//     Given a digit first.leetCode.string, return all possible letter combinations that the number could represent.
//        A mapping of digit to letters (just like on the telephone buttons) is given below.
//        Input:Digit first.leetCode.string "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class LetterCombinations_17 {
    public static List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length()==0) return result;

        result.add("");
        for (int i=0; i<digits.length(); i++)
            result = combine(digitletter[digits.charAt(i)-'0'],result);

        return result;
    }



    public static List<String> combine(String digit,List<String> l){
        List<String> result = new ArrayList<String>();

        for (int i =0;i<digit.length();i++){
            for (String x: l){
                result.add(x+digit.charAt(i));
            }
        }

        return result;
    }
}
