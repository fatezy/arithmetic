package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/10/23  09:44
 */

/*Write an algorithm to determine if a number is "happy".

        A happy number is a number defined by the following process: Starting with any
        positive integer, replace the number by the sum of the squares of its digits, and
        repeat the process until the number equals 1 (where it will stay), or it loops endlessly
        in a cycle which does not include 1. Those numbers for which this process ends in 1 are
        happy numbers.

        Example: 19 is a happy number*/
//对任意一个正整数，不断各个数位上数字的平方和，若最终收敛为1，则该数字为happy number，
     //判断是不是happy number
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            int sum =0;
            while (n!=0){
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            n = sum;
        }
        if (n!= 1) return false;
        return true;
    }
}
