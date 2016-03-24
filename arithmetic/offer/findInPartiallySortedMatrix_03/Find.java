/**
 * 
 */
package findInPartiallySortedMatrix_03;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月5日 下午9:18:12
 */
public class Find {
	
	/**
	 *  一个二维数组从左到右递增，从上到下递增，判断是否含有整数
	 * @param array
	 * @param number
	 * @return 是否含有该整数
	 */
   public static boolean find (int[][] array,int number){
	   if(array == null)
		   return false;
	   int column=array[0].length-1,rows=0;
	   while(rows<array.length&&column>=0){
		   if(array[rows][column] == number){
			   return true;
		   }
		   
		   if(array[rows][column]>number){
			   column--;
			   
		   }
		   else{
			   rows++;
		   }
	   }
	   return false;
   }
}
