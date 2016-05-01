package hashTable;

import java.util.HashSet;

/**
 * author： 张亚飞
 * time：2016/4/23  20:52
 */
//Write an algorithm to determine if a number is "happy".
//
//        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//        Example: 19 is a happy number
//
//        12 + 92 = 82
//        82 + 22 = 68
//        62 + 82 = 100
//        12 + 02 + 02 = 1
    //注：第二个数不是2，是平方的意思
public class IsHappy_202 {
    public boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            int sum =0;
            while (n>0){
                sum +=(n%10)*((n%10));
                n=n/10;

            }
            n=sum;
        }
        if(n == 1) return true;
        else return false;
    }

}
