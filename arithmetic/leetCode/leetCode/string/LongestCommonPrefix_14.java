package leetCode.string;

/**
 * author： 张亚飞
 * time：2016/6/15  22:35
 */
//Write a function to find the longest common prefix leetCode.string amongst an leetCode.array of strings.
    //找出字符串数组的最长公共头子串
public class LongestCommonPrefix_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null||strs.length == 0)
            return "";
        String commonPrefix = strs[0];
        for (String str:strs) {
            commonPrefix = findCommonPrefix(commonPrefix,str);

        }
        return commonPrefix;
    }

    /**
     *
     * @param commonPrefix 公共子串
     * @param str 对比子串
     * @return 最长公共子串
     */
    public static String findCommonPrefix(String commonPrefix,String str){
        if (str.indexOf(commonPrefix) == 0) {
            return commonPrefix;
        }
        int len = commonPrefix.length()<= str.length()?commonPrefix.length():str.length();
        for (int i = 0; i <len ; i++) {
            if (commonPrefix.charAt(i) != str.charAt(i)){
                return commonPrefix.substring(0,i);
            }

        }
        if (commonPrefix.length()<=str.length())
        return commonPrefix;
        else
            return str;
    }


    public static void main(String[] args) {
        String[] str = new String[2];
        str[0] ="aa";
        str[1]="a";
        longestCommonPrefix(str);
    }
}
