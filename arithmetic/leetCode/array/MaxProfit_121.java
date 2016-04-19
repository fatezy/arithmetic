package array;

/**
 * author： 张亚飞
 * time：2016/4/19  18:08
 * 动态规划
 */
//Say you have an array for which the ith element is the price of a given stock on day i.
//        If you were only permitted to complete at most one transaction
//        (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
//        如果只允许进行一次交易，也就是说只允许买一支股票并卖掉，求最大的收益。
public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int low = prices[0];
        int profit = 0;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<low)
                low = prices[i];
            if (profit<prices[i]-low)
                profit = prices[i]-low;
        }
        return profit;

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        MaxProfit_121 maxProfit =new MaxProfit_121();
        System.out.println(maxProfit.maxProfit(a)); 

    }
}
