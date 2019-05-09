package leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/5/4  23:36
 */
//Given an integer, write a function to determine if it is a power of three.
//
//        Follow up:
//        Could you do it without using any loop / recursion?
    //不准递归和迭代
    //求是不是3的幂

public class PowerOfThree_326 {
    //想到一极其变态且变态的方法，老子把3的幂全列举了，绝b效率高
    public boolean isPowerOfThree(int n) {
        Set<Integer> set = new HashSet<>();
        int num = 1;
        int i = 0;
        while (i<=19){
            set.add(new Integer(num));
            num *= 3;
            i++;
        }
        if (set.contains(n))
            return true;
        else
            return false;


    }
}
