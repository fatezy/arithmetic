package stack;

import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/5/6  15:55
 */
//Implement the following operations of a queue using stacks.
//
//        push(x) -- Push element x to the back of queue.
//        pop() -- Removes the element from in front of queue.
//        peek() -- Get the front element.
//        empty() -- Return whether the queue is empty.
    //用栈实现一个队列
public class ImplementQueueusingStacks_232 {
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);

    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!s2.empty()){
            s2.pop();
        }else {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
            s2.pop();
        }

    }

    public int peek() {
        if(!s2.empty())
            return s2.peek();
        else{
            while(!s1.empty())
                s2.push(s1.pop());

            return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(s1.empty()&&s2.empty())
            return true;
        else
            return false;
    }
}
