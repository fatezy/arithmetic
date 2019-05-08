package leetCode.math;

/**
 * author： 张亚飞
 * time：2016/6/12  17:23
 */
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
public class ExcelSheetColumnTitle_168 {
    public static String convertToTitle(int n) {
        String result = "";
        while (n!=0){
            int res = n/26;
            char c;
            if ((n-res*26)==0){
                 c = 'Z';
                n = res-1;
            }else {
                 c = (char) (n - res * 26 + 'A' - 1);
                n=res;
            }
            result += c;

        }
        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        convertToTitle(52);
    }
}
