class Solution {
    // even number of piles => alice turn
    public int maxStonesAliceCanTake(int[] piles, int start, int end, int[][] dp) {
        int turn = (end - start + 1) % 2;
        if (dp[start][end] != 0)
            return dp[start][end];
        if (end - start + 1 == 2)
            dp[start][end] = Math.max(piles[start], piles[end]);
        else if (turn % 2 == 0)
            dp[start][end] = Math.max(piles[start] + maxStonesAliceCanTake(piles, start + 1, end, dp),
                    piles[end] + maxStonesAliceCanTake(piles, start, end - 1, dp));
        else
            dp[start][end] = Math.max(maxStonesAliceCanTake(piles, start + 1, end, dp),
                    maxStonesAliceCanTake(piles, start, end - 1, dp));
        return dp[start][end];
    }

    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles)
            sum += pile;
        int[][] dp = new int[piles.length][piles.length];
        int aliceStone = maxStonesAliceCanTake(piles, 0, piles.length - 1, dp);
        return sum - aliceStone < aliceStone;
    }
}