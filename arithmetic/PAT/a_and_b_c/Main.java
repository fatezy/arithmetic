package a_and_b_c;

import java.util.Scanner;

/**
 * author： 张亚飞
 * time：2016/8/4  21:30
 */
public class Main {
    public static void main(String[] args) {
        int n;
        long a = 0;
        long b = 0;
        long c = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int num = n;
        while (n-- > 0){
            a = in.nextLong();
            b = in.nextLong();
            c = in.nextLong();
            boolean b1 = (a+b)>c ? true : false;
            System.out.println("Case #"+(num-n)+": "+b1);
        }
    }
}
