class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, nums[i]);
        map.put(-1, 1);
        map.put(n, 1);

        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            int i = 0, j = gap;
            while (j < n) {
                if (gap == 0) {
                    dp[i][j] = map.get(i - 1) * nums[i] * map.get(i + 1);
                } else if (gap == 1) {
                    dp[i][j] = map.get(i - 1) * nums[i] * map.get(i + 1) + map.get(j - 2) * nums[j] * map.get(j + 1);
                    dp[i][j] = Math.max(dp[i][j],
                            map.get(j - 1) * nums[j] * map.get(j + 1) + map.get(i - 1) * nums[i] * map.get(i + 2));
                } else {
                    int ans = -1;
                    for (int k = i; k <= j; k++) {
                        ans = Math.max(ans, (k > i ? dp[i][k - 1] : 0) + map.get(i - 1) * nums[k] * map.get(j + 1)
                                + (k < j ? dp[k + 1][j] : 0));
                    }
                    dp[i][j] = ans;
                }
                i++;
                j++;
            }
        }
        return dp[0][n - 1];
    }
}