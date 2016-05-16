/**
 * author： 张亚飞
 * time：2016/5/16  23:08
 */
//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
public class Fibonacci_09 {

    //超时
    public static int Fibonacci(int n) {
        if (n==0){
            return 0;
        }

        if (n==1){
            return 1;
        }

        return Fibonacci(n-1) + Fibonacci(n-2);
    }


    public static int Fibonacci2(int n) {
        if (n==0){
            return 0;
        }

        if (n==1){
            return 1;
        }
        int result = 0;
        int slow = 0,fast = 1;
        int temp = 0;
        for (int i = 2; i <=n ; i++) {
            result = slow +fast;
            if (i<n) {
                slow = fast;
                fast =result;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(Fibonacci2(6));
    }
}
