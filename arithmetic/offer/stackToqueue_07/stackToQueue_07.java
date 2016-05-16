package stackToqueue_07;

import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/5/16  22:52
 */
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class stackToQueue_07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if (!stack2.empty()){
          return   stack2.pop();
        }else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
          return   stack2.pop();
        }

    }

}
