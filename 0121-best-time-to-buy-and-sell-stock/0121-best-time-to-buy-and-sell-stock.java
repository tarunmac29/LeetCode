class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int j = 1;

        while(j < prices.length){
            int profit = prices[j] - prices[i];

            if(prices[j] < prices[i]){
                i = j;
            }

            maxProfit = Math.max(maxProfit, profit);
            j++;
        }

        return maxProfit;

        
    }
}