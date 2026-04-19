class Solution {
    public boolean areEqualStrings(int[] counts1, int[] counts2) {
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (int i = 0; i < s1.length(); i++)
            counts1[s1.charAt(i) - 'a']++;
        int index = 0, start = 0;
        while (index < s1.length()) {
            counts2[s2.charAt(index) - 'a']++;
            index++;
        }
        while (index < s2.length()) {
            if (areEqualStrings(counts1, counts2)) return true;
            counts2[s2.charAt(index) - 'a']++;
            counts2[s2.charAt(start) - 'a']--;
            index++;
            start++;
        }
        return areEqualStrings(counts1, counts2);
    }
}