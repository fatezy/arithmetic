/**
 * 
 */
package leetCode.util;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月10日 下午3:00:44
 */
public class LinkListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkList<Integer> linkList = new LinkList<Integer>();
		linkList.initList(3,4,5);
		//leetCode.linkList.add(4);
		linkList.printList();
		System.out.println(linkList.getSize());
	}

}
