package leetcode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/6  11:08
 */
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given an encoded message containing digits, determine the total number of ways to decode it.
//
//        For example,
//        Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//        The number of ways decoding "12" is 2.
    //给你一个数字判断有多少种解码方式
    //属于爬楼梯问题的加强版
    //number[i] = number[i-1] + number[i-2]
public class DecodeWays_91 {

        public static int numDecodings(String s) {
            if (null==s || "".equals(s))
                return 0;

            int[] arr = new int[s.length()];
            int prev = '0';
            for (int i=0; i<s.length(); i++) {
                int ch = s.charAt(i);
                int count = 0;

                // two digits
                int num = 10*(prev-'0') + (ch-'0');
                int c = 'A'+num-1;
                int prevC = 'A'+(prev-'0')-1;
                if (c>='A' && c<='Z' && prevC>='A' && prevC<='Z') {
                    if (i>1)
                        count += arr[i-2];
                    else if(i==1)
                        count += 1;
                }

                // one digit
                c = 'A'+(ch-'0')-1;
                if (c>='A' && c<='Z') {
                    if (i>0)
                        count += arr[i-1];
                    else
                        count += 1;
                }

                if (count==0)
                    return 0;

                arr[i] = count;
                prev = ch;
            }

            return arr[s.length()-1];
        }

//good method
    public int numDecodings2(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }

        int [] number = new int[s.length() + 1];
        number[0] = 1;
        number[1] = 1;
        int tmp;
        for(int i=2;i<=s.length();i++) {
            //检查当前字符是不是'0'
            tmp = Integer.parseInt(s.substring(i-1,i));
            if(tmp!=0) {
                number[i] = number[i-1];
            }
            //检查当前字符和前一个字符组合在一起是否在1-26之间
            if(s.charAt(i-2)!='0') {
                tmp = Integer.parseInt(s.substring(i-2,i));
                if(tmp>0&&tmp<=26) {
                    number[i] += number[i-2];
                }
            }
        }
        return number[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1212101"));
    }


}
