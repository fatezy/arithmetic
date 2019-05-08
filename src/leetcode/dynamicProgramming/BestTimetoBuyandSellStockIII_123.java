package leetCode.dynamicProgramming;

/**
 * author： 张亚飞
 * time：2016/8/6  20:05
 */
//Say you have an first.leetCode.array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete at most two transactions.
    //最多进行两次交易，求最大的收益
public class BestTimetoBuyandSellStockIII_123 {
    //动态规划，以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i]，
    // 和第i天之后进行一次交易的最大收益postProfit[i]，
    // 最后遍历一遍，max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        //表示于第i天之前进行一次交易
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }

        //表示于第i天之后进行一次交易
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }

        return  maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }


    public static void main(String[] args) {
        int[] a ={1,2,3,4};
        System.out.println(maxProfit2(a));

    }
}
