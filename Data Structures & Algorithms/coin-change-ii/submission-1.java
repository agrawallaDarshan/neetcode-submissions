class Solution {
    public int change(int amount, int[] coins) {
        // knapsack problem
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
            // System.out.println(Arrays.toString(dp[amt]));
        }
        return dp[amount][coins.length - 1];
    }
}

//   1 2 5
// 0 1 1 1
// 1 1 1 1
// 2 1 2 2
// 3 1 2 2
// 4
// 5