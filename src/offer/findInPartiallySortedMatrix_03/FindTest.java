/**
 * 
 */
package offer.findInPartiallySortedMatrix_03;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月5日 下午9:33:46
 */
public class FindTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] testarray = new int[4][4];
		 testarray[0][0]=1;
	        testarray[0][1]=2;
	        testarray[0][2]=8;
	        testarray[0][3]=9;
	        testarray[1][0]=2;
	        testarray[1][1]=4;
	        testarray[1][2]=9;
	        testarray[1][3]=12;
	        testarray[2][0]=4;
	        testarray[2][1]=7;
	        testarray[2][2]=10;
	        testarray[2][3]=13;
	        testarray[3][0]=6;
	        testarray[3][1]=8;
	        testarray[3][2]=11;
	        testarray[3][3]=15;
	        System.out.println(Find.find(testarray, 21));

	}

}
