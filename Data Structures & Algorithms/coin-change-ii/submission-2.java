class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int amt = 0; amt <= amount; amt++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (amt == 0)
                    dp[amt][coin] = 1;
                else {
                    dp[amt][coin] = coin > 0 ? dp[amt][coin - 1] : 0;
                    if (amt >= coins[coin] && dp[amt - coins[coin]][coin] > 0)
                        dp[amt][coin] += dp[amt - coins[coin]][coin];
                }
            }
        }
        return dp[amount][coins.length - 1];
    }
}
