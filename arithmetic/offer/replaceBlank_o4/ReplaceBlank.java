/**
 * 
 */
package replaceBlank_o4;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月5日 下午9:39:52
 */
public class ReplaceBlank {
	/**
	 * 
	 * @param str  需要被替换空格的字符串
	 * @param replace 空格被替换为replace
	 * @return 返回替换后的字符串
	 */
	public String replaceBlank(String str ,String replace){
		StringBuilder stringBuilder = new StringBuilder(str);
		for(int i = 0 ;i<stringBuilder.length();i++){
			if(stringBuilder.charAt(i) == ' '){
				
				stringBuilder.replace(i, i+1, replace);
			}
		}
		return stringBuilder.toString();
		
	}
}
