package leetcode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/4/23  22:07
 */
//You are climbing a stair case. It takes n steps to reach to the top.
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //一次爬一层或两层，有多少种爬的方式
    //背包问题
//利用DP的方法，一个台阶的方法次数为1次，两个台阶的方法次数为2个。
//        n个台阶的方法可以理解成上n-2个台阶，然后2步直接上最后一步；或者上n-1个台阶，再单独上一步。
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }else {
            int[] step =new int[10000];
            step[0] =1;
            step[1] = 2;

            for (int i =2;i<n;i++){
                step[i] = step[i-1] + step[i-2];
            }
            return step[n-1];

        }




    }

}
