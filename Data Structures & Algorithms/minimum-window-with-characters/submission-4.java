class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i)]++;
        int required = t.length(), left = 0, current = 0;
        int minLength = 100001, start = 0;
        while (current < s.length()) {
            if (freq[s.charAt(current)] > 0)
                required--;
            freq[s.charAt(current)]--;
            while (required == 0) {
                if (current - left + 1 < minLength) {
                    minLength = current - left + 1;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0)
                    required++;
                left++;
            }
            current++;
        }
        return minLength == 100001 ? "" : s.substring(start, start + minLength);
    }
}