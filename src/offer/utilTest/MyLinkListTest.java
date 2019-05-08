/**
 * 
 */
package offer.utilTest;

import offer.util.MyLinkList;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月5日 下午11:44:30
 */
public class MyLinkListTest {

	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{12,45,2,43,56};
		MyLinkList<Integer> list = new MyLinkList<Integer>(a,5);
		list.printMyLinkList();
		list.ReverseList();
	

	}

}
