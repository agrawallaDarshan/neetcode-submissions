class Solution {
    public boolean solution(String s, int index, int count, Boolean[][] dp) {
        if (count < 0)
            return false;
        if (index == s.length())
            return count == 0;
        char ch = s.charAt(index);
        if (dp[index][count] != null) 
            return dp[index][count];
        if (ch == '(')
            dp[index][count] = solution(s, index + 1, count + 1, dp);
        else if (ch == ')')
            dp[index][count] = solution(s, index + 1, count - 1, dp);
        else
            dp[index][count] = solution(s, index + 1, count, dp) || solution(s, index + 1, count + 1, dp)
                    || solution(s, index + 1, count - 1, dp);
        return dp[index][count];
    }

    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return solution(s, 0, 0, dp);
    }
}