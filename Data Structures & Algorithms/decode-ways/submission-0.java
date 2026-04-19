class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int n = s.length();
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        if (s.charAt(1) != '0')
            dp[1]++;
        int number = Integer.parseInt("" + s.charAt(0) + s.charAt(1));
        if (number < 27)
            dp[1]++;
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];
            if (s.charAt(i - 1) != '0') {
                number = Integer.parseInt("" + s.charAt(i - 1) + s.charAt(i));
                if (number > 0 && number < 27)
                    dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}