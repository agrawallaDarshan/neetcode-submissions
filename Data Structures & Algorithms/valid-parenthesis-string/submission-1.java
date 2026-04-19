class Solution {
    public boolean solution(String s, int index, int count) {
        if (count < 0)
            return false;
        if (index == s.length())
            return count == 0;
        char ch = s.charAt(index);
        if (ch == '(')
            return solution(s, index + 1, count + 1);
        if (ch == ')')
            return solution(s, index + 1, count - 1);
        else
            return solution(s, index + 1, count) || solution(s, index + 1, count + 1)
                    || solution(s, index + 1, count - 1);
    }

    public boolean checkValidString(String s) {
        return solution(s, 0, 0);
    }
}