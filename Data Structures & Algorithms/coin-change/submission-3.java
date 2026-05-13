class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int result = dfs(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int[] coins, int amount, int[] dp){
        //base case
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != 0){
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            //dp[amount] = 1 + Math.min(dp[amount - 1])
            if(amount - coin >= 0){
                int result = dfs(coins, amount - coin, dp);
                if(result != Integer.MAX_VALUE){
                    res = Math.min(res, result + 1);
                }
            }
        }
        dp[amount] = res;
        return dp[amount];
    }
}
