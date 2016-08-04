package char_count_2;

import java.util.Scanner;

/**
 * author： 张亚飞
 * time：2016/8/4  20:17
 */
//题目描述
//
//        写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。
// 不区分大小写。
//
//        输入描述:
//        输入一个有字母和数字以及空格组成的字符串，和一个字符。
//
//
//        输出描述:
//        输出输入字符串中含有该字符的个数。
//
//        输入例子:
//        ABCDEF
//        A
//
//        输出例子:
//        1
public class Main {
    public static int charCount(String s,char target){
         s = s.toLowerCase();
        target = Character.toLowerCase(target);
        int count = 0;
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (c == target){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            String c = in.nextLine();
            System.out.println(charCount(s,c.charAt(0)));
        }

    }
}
