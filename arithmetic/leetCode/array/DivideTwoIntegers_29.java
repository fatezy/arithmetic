package array;

/**
 * author： 张亚飞
 * time：2016/8/1  21:02
 */
//Divide two integers without using multiplication, division and mod operator.
//
//        If it is overflow, return MAX_INT.
    //进行除法运算不可以进行乘，除，模运算
public class DivideTwoIntegers_29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == -2147483648 && divisor== -1)
            return 2147483647;
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }


    /**
     * 正整数进行的除法运算
     *类似于二分的思想
     * @param dividend
     * @param divisor
     * @return
     */
    public static int ldivide(long dividend,long divisor){
        if (dividend < divisor){
            return 0;
        }

        long sum = divisor;
        //没次扩大的倍数
        int times = 1;
        while ((sum+sum)<dividend){
            sum+=sum;
            times+=times;
        }

        return times+ldivide(dividend-sum,divisor);

    }


    public static void main(String[] args) {
        System.out.println(ldivide(10, 5));
    }
}
