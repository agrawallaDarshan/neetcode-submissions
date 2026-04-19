class Solution {
    public int solve(int[] piles, int start, int M, int turn, int[] sum, HashMap<String, Integer> dp) {
        if (start >= piles.length)
            return 0;
        StringBuilder sb = new StringBuilder();
        String key = sb.append(start).append("-").append(M).append("-").append(turn).toString();
        if (dp.containsKey(key))
            return dp.get(key);
        int maxPiles = Math.min(2 * M, piles.length - start);
        int pile = 0, res = 0;
        if (turn % 2 == 0) {
            while (pile < maxPiles) {
                int stones = sum[start + pile] - (start > 0 ? sum[start - 1] : 0);
                pile++;
                res = Math.max(res, stones + solve(piles, start + pile, Math.max(M, pile), turn + 1, sum, dp));
            }
        } else {
            res = Integer.MAX_VALUE;
            while (pile < maxPiles) {
                pile++;
                res = Math.min(res, solve(piles, start + pile, Math.max(M, pile), turn + 1, sum, dp));
            }
        }
        dp.put(key, res);
        return res;
    }

    public int stoneGameII(int[] piles) {
        int[] sum = new int[piles.length];
        int value = 0;
        for (int i = 0; i < piles.length; i++) {
            value += piles[i];
            sum[i] = value;
        }
        HashMap<String, Integer> dp = new HashMap<>();
        return solve(piles, 0, 1, 0, sum, dp);
    }
}