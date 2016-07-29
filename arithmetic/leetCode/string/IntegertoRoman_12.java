package string;

/**
 * author： 张亚飞
 * time：2016/7/29  09:49
 */
//Given an integer, convert it to a roman numeral.
//
//        Input is guaranteed to be within the range from 1 to 3999.

    //把integer转化为罗马数字
public class IntegertoRoman_12 {
    public String intToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
