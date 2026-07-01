class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch1 = s.charAt(right);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            while (right - left + 1 > map.size()) {
                char ch2 = s.charAt(left);
                if (map.get(ch2) == 1)
                    map.remove(ch2);
                else
                    map.put(ch2, map.get(ch2) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}