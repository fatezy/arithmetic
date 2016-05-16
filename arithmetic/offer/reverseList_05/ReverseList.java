package reverseList_05;

import util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//题目描述
//
//        输入一个链表，从尾到头打印链表每个节点的值。
//        输入描述:
//        输入为链表的表头
//
//
//        输出描述:
//        输出为需要打印的“新链表”的表头
public class ReverseList{

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}
