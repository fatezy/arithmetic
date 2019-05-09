package leetcode.BinarySearch;

/**
 * author： 张亚飞
 * time：2016/4/27  16:36
 */
//Implement pow(x, n).
    //求x的n次幂
public class Pow_50 {
    public double myPow(double x, int n) {
        if(n==0)    return 1;
        else if(n==1)   return x;
        if(n<0&&n>Integer.MIN_VALUE) return 1/myPow(x,-n);
        else if(n==Integer.MIN_VALUE)   return 1/myPow(x*x,n>>1);
        if(n%2==0)  return myPow(x*x,n>>1);
        else    return myPow(x*x,n>>1)*x;
    }
}
