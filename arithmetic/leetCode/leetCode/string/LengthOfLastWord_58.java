package leetCode.string;

/**
 * author： 张亚飞
 * time：2016/4/21  18:20
 */
//Given a leetCode.string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the leetCode.string.
//
//        If the last word does not exist, return 0.
//
//        Note: A word is defined as a character sequence consists of non-space characters only.
//
//        For example,
//        Given s = "Hello World",
//        return 5.
    //返回最后一个字符串长度
public class LengthOfLastWord_58 {
    //返回的是整个字符串中最长的，并不是最后一个字符串，不看题-.-
    public int lengthOfLastWord(String s) {
        if(s==null)
            return 0;
        if (s.length()==0)
            return 0;
        int length = 0;
        int len = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)!=' '){
                len++;
                if (len > length){
                    length = len;
                }
            }else {
                len = 0;
            }
        }
        return length;
    }
    public int lengthOfLastWord2(String s) {
        if(s==null)
            return 0;
        if (s.length()==0)
            return 0;
        s=s.trim();
        int len =0 ;
        for (int i = s.length()-1; i >=0 ; i--) {

            if (s.charAt(i)==' ') {

                return len;

            }
            len++;
        }
        return len;
    }
}
