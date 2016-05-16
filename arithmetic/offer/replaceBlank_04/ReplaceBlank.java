/**
 * 
 */
package replaceBlank_04;

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

	public static String replaceSpace(StringBuffer str) {
		String  str2 = str.toString();
		str2 = str2.replace(" ","%20");
		return str2;
	}

	public static void main(String[] args) {
		StringBuffer stringBuffer= new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(stringBuffer));
	}

}
