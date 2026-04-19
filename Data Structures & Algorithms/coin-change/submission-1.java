class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int coin = 0; coin < coins.length; coin++) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coins[coin]) {
                    int remainingAmount = i - coins[coin];
                    if (remainingAmount == 0) dp[i] = 1;
                    else if (dp[remainingAmount] > 0) {
                        if (dp[i] == 0) dp[i] = 1 + dp[remainingAmount];
                        else dp[i] = Math.min(dp[i], 1 + dp[remainingAmount]);
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
