package string;

import org.junit.Test;

/**
 * author： 张亚飞
 * time：2016/4/26  21:30
 */
//Write a function that takes a string as input and returns the string reversed.
//
//        Example:
//        Given s = "hello", return "olleh".
    //逆转字符串
public class ReverseString_344 {
    public String reverseString(String s) {
        if (s.length()<=1)
            return s;
       char[] res = new char[s.length()];
        int t = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            res[t] = s.charAt(i);
            t++;


        }
        return String.valueOf(res);

    }
    @Test
    public void  test(){
        System.out.println(reverseString("hello"));
    }
}
