class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            } else {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                } 
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
            }
        }
        return true;
    }
}
