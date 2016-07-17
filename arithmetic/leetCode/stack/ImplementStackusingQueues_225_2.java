package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/7/17  11:16
 */
public class ImplementStackusingQueues_225_2 {
    Stack<Integer> stack = new Stack<>();


    public void push(int x) {
      stack.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.pop();
    }

    // Get the top element.
    public int top() {
       return stack.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.empty();
    }

}
