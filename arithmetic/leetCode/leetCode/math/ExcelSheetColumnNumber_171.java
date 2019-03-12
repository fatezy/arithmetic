package leetCode.math;

/**
 * author： 张亚飞
 * time：2016/7/26  14:52
 */
//Related to question Excel Sheet Column Title
//
//        Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//        For example:
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
    //把excel的数据转化为正常的数字
public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String s) {
        if (s==null && s.length()==0){
            return 0;
        }
        StringBuffer strBuf = new StringBuffer(s);
        s = strBuf.reverse().toString();
        int res = 0;
        for (int i = 0; i <s.length() ; i++) {
            res += (s.charAt(i) - 'A'+1) *(Math.pow(26,i));

        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));

    }
}
