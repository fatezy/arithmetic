package dynamicProgramming;

import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/8/3  15:36
 */
//Given a string containing just the characters '(' and ')', find the length of the longest valid
// (well-formed) parentheses substring.
//
//        For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//        Another example is ")()())", where the longest valid parentheses substring is "()()",
// which has length = 4.

    //给你一个字符串，里面只有左括号和右括号，给出最长有效的字符串
    //设想把所有可以标为有配对的括号标为1，所有没有配对的括号标为0
    //则此问题便会转换为找出都是1的最长子串
public class LongestValidParentheses_32 {
    //超时？？？？
    public static int longestValidParentheses(String s) {
        int res=0;
        int tep=0;
        Stack<Integer> stack = new Stack<>();
        int[] datas = new int[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }else if (!stack.empty()){
                datas[i] = 1;
                datas[stack.pop()] = 1;

            }
        }

        for(int i:datas){
            if(i==1) tep++;
            else {res=Math.max(tep,res);tep=0;}
        }
        return Math.max(tep,res);


    }


    public int longestValidParentheses2(String s) {
        int res=0;
        int tep=0;
        Stack<Integer> s1=new Stack<>();
        int data[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') s1.push(i);
            else{
                if(!s1.empty()){
                    data[i]=1;
                    data[s1.pop()]=1;
                }
            }
        }
        for(int i:data){
            if(i==1) tep++;
            else {res=Math.max(tep,res);tep=0;}
        }
        return Math.max(tep,res);
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")))(()))"));
    }
}
