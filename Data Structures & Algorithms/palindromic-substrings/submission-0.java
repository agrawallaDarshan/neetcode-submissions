class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;
        for (int diagonal = 0; diagonal < n; diagonal++) {
            int i = 0, j = diagonal;
            while (j < n) {
                if (i == j)
                    dp[i][j] = true;
                else if (j - i == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (dp[i][j])
                    result++;
                i++;
                j++;
            }
        }
        return result;
    }
}
