package Interviewguide;

import java.util.Stack;

public class SortStack{
    public static  void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.empty()){
            Integer curr = stack.pop();
            if(help.empty() || curr<=help.peek()){
                help.push(curr);
            }else{
                while(!help.empty()){
                    stack.push(help.pop());
                }
                help.push(curr);
                while(!stack.empty()&&stack.peek()<curr){
                    help.push(stack.pop());
                }
            }
        } //while
        while(!help.empty()){
            stack.push(help.pop());
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        sortStackByStack(stack);
        for (int i = 0; i <4; i++) {
            System.out.println(stack.pop());
        }
    }
}