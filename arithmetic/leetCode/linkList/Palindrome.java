/**
 * 
 */
package linkList;

import java.util.ArrayList;
import java.util.List;

import util.LinkList;
import util.Node;

/**
 * 判断链表是否回文,用list储存链表，然后判断是否回文
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月10日 下午5:02:22
 */
public class Palindrome<T> extends LinkList<T>{
	/**
	 * 用list保存链表后判断,此方法空间复杂度较高o(n)
	 * 
	 * @param head
	 * @return
	 */
  public boolean  palindromeByList(Node<T> node){
	  List<Node<T>> list =new ArrayList<Node<T>>();
  
  		boolean flag = true;
  		//把链表放入list中
	  while(node != null){
  		list.add(node);
  		node = node.next;
  	}
	  //比较是否回文
  	for(int i = 0;i<list.size()/2;i++){
  		if(list.get(i).value != list.get(list.size()-i-1).value){
  			flag = false;
  		}
  		
  	}
	  return flag;
  }
  /**
   * 
   * @param node
   * @return
   */
  public boolean palindrome(Node<T> node){
	  return true;
  }
    
    public static void main(String[] args) {
    	List<Node<Integer>> list =new ArrayList<Node<Integer>>();
    	Palindrome<Integer> linkList = new Palindrome<Integer>();
    	boolean flag = true;
		linkList.initList(4,3,4,3);
		Node<Integer> node = linkList.getFirstNode();
		System.out.println(linkList.palindromeByList(node));

   
}
}
