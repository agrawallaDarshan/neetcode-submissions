class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (i == coins[coin])
                    dp[i] = 1;
                else if (i >= coins[coin]) {
                    if (dp[i - coins[coin]] > 0) {
                        if (dp[i] == 0)
                            dp[i] = 1 + dp[i - coins[coin]];
                        else
                            dp[i] = Math.min(dp[i], 1 + dp[i - coins[coin]]);
                    }
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}