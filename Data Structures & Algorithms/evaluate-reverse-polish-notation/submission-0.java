class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                //perform the operation
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int result = 0;
                if (token.equals("+")) result = a + b;
                else if (token.equals("-")) result = a - b;
                else if (token.equals("*")) result = a * b;
                else if (token.equals("/")) result = a / b;
                st.push(Integer.toString(result));
            } else {
                st.push(token);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
