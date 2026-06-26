class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0, j = 0, n = strs.length - 1;
        while (i < strs[0].length() && j < strs[n].length() && strs[0].charAt(i) == strs[n].charAt(j)) {
            i++;
            j++;
        }
        return strs[0].substring(0, i);
    }
}