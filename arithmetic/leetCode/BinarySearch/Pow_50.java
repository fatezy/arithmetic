package BinarySearch;

/**
 * author： 张亚飞
 * time：2016/4/27  16:36
 */
//Implement pow(x, n).
    //求x的n次幂
public class Pow_50 {
    double pow(double x, int n)
    {
        if(n==0)
            return 1.0;
        if(n<0)
            return 1.0/pow(x,-n);
        return x*pow(x,n-1);
    }
}
