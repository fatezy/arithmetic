import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/7/31  21:34
 */
//请实现一个算法，确定一个字符串的所有字符是否全都不同。
// 这里我们要求不允许使用额外的存储结构。
//        给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，
// False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
public class Different {
    public boolean checkDifferent(String iniString) {
        boolean flag = true;
        Set<Character> set = new HashSet<>();
        if (iniString == null || iniString.length() == 0){
            return true;
        }
        for (int i = 0; i <iniString.length() ; i++) {
            if (!set.add(iniString.charAt(i))){
                flag = false;
            }
        }
        return flag;
    }
}
