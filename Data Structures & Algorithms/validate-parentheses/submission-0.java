class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(')
                st.push(ch);
            else {
                char openingBracket = ' ';
                if (ch == '}')
                    openingBracket = '{';
                else if (ch == ']')
                    openingBracket = '[';
                else
                    openingBracket = '(';
                if (st.isEmpty() || st.peek() != openingBracket)
                    return false;
                st.pop();
            }
        }
        return st.size() == 0 ? true : false;
    }
}