class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                if (j >= coins[i]) {
                    int remainingAmount = j - coins[i];
                    dp[i][j] += dp[i][remainingAmount];
                    if (i - 1 >= 0)
                        dp[i][j] += dp[i - 1][j];
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}