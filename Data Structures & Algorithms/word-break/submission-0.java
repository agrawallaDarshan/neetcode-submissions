class Solution {
    public boolean isWordExists(String s, int index, Set<String> dict, int[] dp) {
        System.out.println("index = " + index);
        if (index == s.length()) return true;
        if (dp[index] != 0) return dp[index] == 1;
        boolean result = false;
        for (int i = index; i < s.length() && !result; i++) {
            String cstr = s.substring(index, i + 1);
            if (dict.contains(cstr)) {
                result |= isWordExists(s, i + 1, dict, dp);
            }
        }
        dp[index] = result ? 1 : 2;
        return result;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict)
            set.add(word);
        int[] dp = new int[s.length()]; // 1 = true, 2 = false
        return isWordExists(s, 0, set, dp);
    }
}