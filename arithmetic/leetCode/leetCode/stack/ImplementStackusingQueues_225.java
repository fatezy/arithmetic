package leetCode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author： 张亚飞
 * time：2016/7/17  11:12
 */
public class ImplementStackusingQueues_225 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public void push(int x) {
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
    }

    // Removes the element on top of the leetCode.stack.
    public void pop() {
        q2.poll();
    }

    // Get the top element.
    public int top() {
        return q2.peek();
    }

    // Return whether the leetCode.stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
