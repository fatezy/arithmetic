package leetCode.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/7/25  21:55
 */
//
//Design a first.leetCode.stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto first.leetCode.stack.
//        pop() -- Removes the element on top of the first.leetCode.stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the first.leetCode.stack.
//        Example:
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> Returns -3.
//        minStack.pop();
//        minStack.top();      --> Returns 0.
//        minStack.getMin();   --> Returns -2.
    //实现一个微型栈
public class MinStack_155 {
    List<Integer> list = null;
    public MinStack_155() {
         list = new ArrayList<>();


    }

    public void push(int x) {
        list.add(x);

    }

    public void pop() {
        if (list.size()>0) {
            list.remove(list.get(list.size() - 1));
        }

    }

    public int top() {
        if (list.size()>0) {
            return list.get(list.size() - 1);
        }else {
            return 0;
        }
    }

    public int getMin() {
        List<Integer> temp = new ArrayList<>(list);
        Collections.sort(temp);
        return temp.get(0);
    }

    public static void main(String[] args) {
        MinStack_155 minStack_155 = new MinStack_155();
        minStack_155.push(1);
        minStack_155.push(2);
        minStack_155.push(0);
        minStack_155.push(3);
        minStack_155.push(0);
        System.out.println(minStack_155.getMin());

    }

}
