class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;

        int maxProfit = 0;

        while(j < prices.length){
            int profit = prices[j] - prices[i];

            if(prices[i] < prices[j]){
                maxProfit = Math.max(profit, maxProfit);
                j++;
            }else{
                i = j;
                j++;
            }
        }
        return maxProfit;
    }
}