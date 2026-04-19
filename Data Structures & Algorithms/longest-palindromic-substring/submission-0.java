class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int startIndex = 0, endIndex = 0, length = 1;
        // Diagonal traversal
        for (int diagonal = 0; diagonal < n; diagonal++) {
            int i = 0, j = diagonal;
            while (j < n) {
                if (i == j) dp[i][j] = true;
                else if (j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));

                if (dp[i][j] && j - i + 1 > length) {
                    length = j -  i + 1;
                    startIndex = i;
                    endIndex = j;
                }
                i++;
                j++;
            }           
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
