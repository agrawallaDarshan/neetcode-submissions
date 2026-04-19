class Solution {
    public boolean solution(String s, String p, int index1, int index2) {
        if (index1 == s.length() && index2 == p.length())
            return true;
        if (index2 == p.length())
            return false;
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if (solution(s, p, index1, index2 + 2))
                return true;
            int index = index1;
            while (index < s.length()
                    && (p.charAt(index2) == '.' || s.charAt(index) == p.charAt(index2))) {
                if (solution(s, p, index + 1, index2 + 2))
                    return true;
                index++;
            }
            return false;
        } else if (index1 < s.length() && (p.charAt(index2) == '.' || s.charAt(index1) == p.charAt(index2))) {
            return solution(s, p, index1 + 1, index2 + 1);
        } else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        return solution(s, p, 0, 0);
    }
}