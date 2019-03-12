package leetCode.greedy;

/**
 * author： 张亚飞
 * time：2016/5/4  23:03
 */
//Say you have an leetCode.array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like
// (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
// transactions at the same time
//(ie, you must sell the stock before you buy again).
//用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
    //一次只能操作一只股票，可多次交易，求最大的收益
public class MaxProfit2_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length<2)
            return 0;
        for (int i = 1; i <prices.length ; i++) {
            profit += ( prices[i]>prices[i-1] ? prices[i]-prices[i-1] : 0);
        }
        return profit;


    }
}
