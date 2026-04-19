class Solution {
    public int solution(int[] prices, int index, int n, int buyPrice, int[][] dp) {
        if (index >= n)
            return 0;
        if (dp[index][buyPrice] != -1)
            return dp[index][buyPrice];
        if (prices[index] <= buyPrice)
            dp[index][buyPrice] = solution(prices, index + 1, n, prices[index], dp);
        else
            dp[index][buyPrice] = Math.max(prices[index] - buyPrice + solution(prices, index + 2, n, 1001, dp),
                    solution(prices, index + 1, n, buyPrice, dp));
        return dp[index][buyPrice];
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][1002];
        for (int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        return solution(prices, 1, prices.length, prices[0], dp);
    }
}
