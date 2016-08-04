/**
 * author： 张亚飞
 * time：2016/8/1  20:32
 */
public class Reverse {
    public String reverseString(String iniString) {
        if (iniString == null || iniString.length() == 0 ){
            return iniString;
        }
       StringBuffer stringBuffer = new StringBuffer(iniString);
        return stringBuffer.reverse().toString();
    }
}
