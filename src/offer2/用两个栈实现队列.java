package offer2;

import java.util.Stack;

/**
 * Created by 张亚飞 on 2019/3/16.
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()){
            return stack2.pop();
        }else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}

 