package Interviewguide;

import java.util.Stack;

public class ReveseStack{

    //将栈底数据移除并返回
    public static int getAndRemoveLast(Stack<Integer> stack)  	{
        int result = stack.pop();
        if(stack.empty()){
            return result;
        }else{
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }
    //逆序栈
    public static void revese(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }

        int i = getAndRemoveLast(stack);
        revese(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        ReveseStack.revese(stack);
        for (int i = 0; i <4; i++) {
            System.out.println(stack.pop());
        }
    }
}