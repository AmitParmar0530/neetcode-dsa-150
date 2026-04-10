class Solution {
    public int maxProfit(int[] prices) {
        int windowStart = 0;
        int maxProfit = 0;

        for(int windowEnd = 1; windowEnd < prices.length; windowEnd++){

            if(prices[windowStart] > prices[windowEnd]){
                windowStart = windowEnd;
            } else {
                int profit = prices[windowEnd] - prices[windowStart];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
