class Solution {
    public void generateAllParenthesis(int open, int close, int n, String s, List<String> result) {
        if (open == n && close == n) {
            result.add(s);
            return;
        }
        if (open == n) {
            int closeParenthesisRequired = n - close;
            String closeParentheses = "";
            while (closeParenthesisRequired > 0) {
                closeParentheses += ")";
                closeParenthesisRequired--;
            }
            generateAllParenthesis(open, n, n, s + closeParentheses, result);
        } else if (open == close) {
            generateAllParenthesis(open + 1, close, n, s + "(", result);
        } else {
            generateAllParenthesis(open + 1, close, n, s + "(", result);
            generateAllParenthesis(open, close + 1, n, s + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllParenthesis(0, 0, n, "", result);
        return result;
    }
}