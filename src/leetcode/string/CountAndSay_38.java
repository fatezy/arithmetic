package leetcode.string;

/**
 * author： 张亚飞
 * time：2016/4/21  21:17
 */
//The count-and-say sequence is the sequence of integers beginning as follows:
//        1, 11, 21, 1211, 111221, ...
//
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
    //写出几次以后的数
public class CountAndSay_38 {
    //跑不起
    public String countAndSay(int n) {
        String  s = "1";
        String result = "";
        char t = '1';
        int length = 1;
        for (int i = 0; i <n ; i++) {
            t=s.charAt(0);
            for (int j = 0; j <s.length() ; j++) {
                if (t!=s.charAt(j)||j==s.length()-1){
                    result=result+String.valueOf(length)+t;
                    if (j!=s.length()-1){
                        t=s.charAt(j);
                        length = 1;

                    }
                    if (j==s.length()-1){
                        s= result;
                        if (i!=n-1){
                            result="";
                            length = 1;
                        }


                        break;
                    }
                }else {
                    length++;
                }

            }

        }
        return result;
    }



    public static void main(String[] args) {
        CountAndSay_38 countAndSay_38 =new CountAndSay_38();

        System.out.println( countAndSay_38.countAndSay(3));
    }
}