class Solution {
    public int aliceScore(int[] piles, int start, int turn, int[] sum, int[][] dp) {
        if (start >= piles.length)
            return 0;
        if (dp[start][turn] != 0)
            return dp[start][turn];
        int maxPiles = Math.min(3, piles.length - start);
        int pile = 0;
        if (turn % 2 == 0) {
            dp[start][turn] = Integer.MIN_VALUE;
            while (pile < maxPiles) {
                int stones = sum[start + pile] - (start > 0 ? sum[start - 1] : 0);
                pile++;
                dp[start][turn] = Math.max(dp[start][turn],
                        stones + aliceScore(piles, start + pile, turn + 1, sum, dp));
            }
        } else {
            dp[start][turn] = Integer.MAX_VALUE;
            while (pile < maxPiles) {
                pile++;
                dp[start][turn] = Math.min(dp[start][turn], aliceScore(piles, start + pile, turn + 1, sum, dp));
            }
        }
        return dp[start][turn];
    }

    public String stoneGameIII(int[] piles) {
        int[] sum = new int[piles.length];
        int value = 0;
        for (int i = 0; i < piles.length; i++) {
            value += piles[i];
            sum[i] = value;
        }
        int[][] dp = new int[piles.length][piles.length];
        int aliceScore = aliceScore(piles, 0, 0, sum, dp);
        int bobScore = value - aliceScore;
        if (aliceScore > bobScore)
            return "Alice";
        else if (bobScore > aliceScore)
            return "Bob";
        return "Tie";
    }
}