package leetcode.math;

/**
 * author： 张亚飞
 * time：2016/5/4  23:23
 */
//Write a program to check whether a given number is an ugly number.
//
//        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
    //判断是不是丑数
    //数字也有歧视
public class UglyNumber_263 {
    public boolean isUgly(int num) {
        if(num == 0) {
            return false;
        }
        while(num % 5 == 0) {
            num /= 5;
        }
        while(num % 3 == 0) {
            num /= 3;
        }
        while(num % 2 == 0) {
            num /= 2;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }
}
