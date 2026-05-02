class Solution {
    public boolean compareFerquencies(int[] freq1, int[] freq2) {
        for (int i = 0; i < 128; i++)
            if (freq1[i] < freq2[i])
                return false;
        return true;
    }

    public String minWindow(String s, String t) {
        int[] freq1 = new int[128]; // s
        int[] freq2 = new int[128]; // t
        // tc -> O(n)
        for (int i = 0; i < t.length(); i++)
            freq2[t.charAt(i)]++;
        // tc -> O(m + n)
        int start = -1, end = -1;
        int left = 0, current = 0;
        while (current < s.length()) {
            freq1[s.charAt(current)]++;
            while (compareFerquencies(freq1, freq2)) {
                if (current - left + 1 == t.length())
                    return s.substring(left, current + 1);
                if ((start == -1 && end == -1) || (current - left < end - start)) {
                    start = left;
                    end = current;
                }
                freq1[s.charAt(left)]--;
                left++;
            }
            current++;
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}