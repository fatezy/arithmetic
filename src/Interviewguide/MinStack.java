package Interviewguide;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);

        if(stackMin.empty()||x<=stackMin.peek()){
            stackMin.push(x);
        }

    }

    public void pop() {
        if(stackData.isEmpty()){
            return;
        }
        if(stackData.peek().equals(stackMin.peek())){
            stackMin.pop();
        }
        stackData.pop();
    }

    public int top() {

        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }
}
