package leetCode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/5/6  15:26
 */
//Given a first.leetCode.string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input first.leetCode.string is valid.
//
//        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    //括号配对
public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        if (s == null)
            return true;
        if (s.length()==0)
            return true;
        int len = s.length();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <len ; i++) {
            if (stack.empty() == true){
                stack.push(s.charAt(i));
            }else {
                Character character = s.charAt(i);
                if (map.get(stack.peek()) == character){
                    stack.pop();
                }else {
                    stack.push(character);
                }
            }


        }
        System.out.println(stack.empty());
        return stack.empty();
    }

    public static void main(String[] args) {
        isValid("[]");
    }


}
