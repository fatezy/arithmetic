package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/10/22  23:29
 */
/*A linked list is given such that each node contains an additional random pointer
 which could point to any node in the list or null.
        Return a deep copy of the list.*/
    //拷贝一个链表。每个链表节点带有两个子节点，
// 一个指向下个节点，另一个随机指向任意节点

/**
 * 解题思路：第一步先遍历所给链表的所有节点，并用map存储拷贝节点与原节点的对应关系
 * 第二步根据对应关系去保存找到对应节点的随机指向
 */
public class CopyListwithRandomPointer_138 {
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = head;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode copyHead = new RandomListNode(Integer.MAX_VALUE);
        RandomListNode copyHeadTemp = copyHead;
        while (temp !=null){
            RandomListNode tempCopy = new RandomListNode(temp.label);
            copyHeadTemp.next = tempCopy;
            map.put(temp,tempCopy);
            copyHeadTemp = copyHeadTemp.next;
            temp=temp.next;
        }
        temp = head;
        copyHeadTemp = copyHead.next;

        while (temp!=null){
            copyHeadTemp.random=map.get(temp.random);
            copyHeadTemp=copyHeadTemp.next;
            temp=temp.next;
        }
        return copyHead.next;

    }

    public static void main(String[] args) {

    }

}


class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
    }
