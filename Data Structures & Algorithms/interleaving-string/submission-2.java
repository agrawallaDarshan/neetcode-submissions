class Solution {
    public boolean solution(String s1, String s2, String target, int index1, int index2, int index, int[][] dp) {
        if (index == target.length())
            return true;
        if (dp[index1][index2] != 0)
            return dp[index1][index2] == 1;
        char ch = target.charAt(index);
        boolean ans = (index1 < s1.length() && s1.charAt(index1) == ch
                && solution(s1, s2, target, index1 + 1, index2, index + 1, dp)) ||
                (index2 < s2.length() && s2.charAt(index2) == ch
                        && solution(s1, s2, target, index1, index2 + 1, index + 1, dp));
        dp[index1][index2] = ans ? 1 : 2;
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        return solution(s1, s2, s3, 0, 0, 0, dp);
    }
}