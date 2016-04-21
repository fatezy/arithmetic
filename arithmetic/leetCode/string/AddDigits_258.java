package string;

/**
 * author： 张亚飞
 * time：2016/4/21  17:07
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        String s = String.valueOf(num);
        num =0;

        for (int i = 0; i <s.length() ; i++)
            num += Integer.parseInt(String.valueOf(s.charAt(i)));


        return num>9?addDigits(num): num;
    }

}
