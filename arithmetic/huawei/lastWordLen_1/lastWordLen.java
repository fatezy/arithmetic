package lastWordLen_1;

import java.util.Scanner;

/**
 * author： 张亚飞
 * time：2016/8/4  20:04
 */
//计算字符串最后一个单词的长度，单词以空格隔开。
//
//        输入描述:
//        一行字符串，非空，长度小于5000。
//
//
//        输出描述:
//        整数N，最后一个单词的长度。

public class lastWordLen {
    public static int lastWordLen(String s){
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
           String str = in.nextLine();
            System.out.println(lastWordLen(str));
        }
    }
}
