public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        char[] c = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        
        for (int i = 0; i < c.length; i ++){
            
            if (c[i] == '(' || c[i] == '[' || c[i] == '{'){
                st.push(c[i]);
                continue;
            }
            
            if (c[i] == ')'){
                if (st.isEmpty() || st.pop() != '('){
                    return false;
                }
            }
            
            if (c[i] == ']'){
                if (st.isEmpty() || st.pop() != '['){
                    return false;
                }
            }
            
            if (c[i] == '}'){
                if (st.isEmpty() || st.pop() != '{'){
                    return false;
                }
            }
           
            
        }
        return st.isEmpty();

    }
}
