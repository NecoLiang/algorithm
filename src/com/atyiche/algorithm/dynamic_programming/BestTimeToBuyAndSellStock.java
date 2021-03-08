package com.atyiche.algorithm.dynamic_programming;

/**
 * @author liangyt
 * @create 2021-03-08 17:03
 */
public class BestTimeToBuyAndSellStock {
    //方法一：暴力法
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        // 遍历所有两两组合
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i; j < prices.length; j++){
                int curProfit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, curProfit);
            }
        }
        return maxProfit;
    }
    //方法二：动态规划
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // 遍历数组，以每天的价格作为卖出点，进行比较
        for (int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price1 = {7,1,5,3,6,4};
        int[] price2 = {7,6,4,3,1};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(price1));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(price2));
    }

}
