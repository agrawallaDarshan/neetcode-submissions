class Solution {
    public void generatePalindromePartions(int index, String s, List<String> subString, List<List<String>> result, boolean[][] dp) {
        if(index == s.length()){
            result.add(new ArrayList<>(subString));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(dp[index][i]){
                subString.add(s.substring(index,i+1));
                generatePalindromePartions(i+1, s, subString, result, dp);
                subString.remove(subString.size() - 1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n-1; j >= i; j--) {
                if (i == j) dp[i][j] = true;
                else if(j - i > 1) dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                else dp[i][j] = s.charAt(i) == s.charAt(j);
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> subString = new ArrayList<>();
        generatePalindromePartions(0, s, subString, result, dp);
        return result;
    }

}