class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            } 
            if (c == ' '){
                continue;
            } 
            if (!Character.isDigit(c) || i == s.length() - 1){
                if (sign == '+'){
                    stack.push(num);
                }
                if (sign == '-'){
                    stack.push(num * -1);
                }
                if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if (sign == '/'){
                                   
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0; 
            }
        }
        
        int result = 0;
         System.out.println(stack);
        for (int i: stack){
            result = result + i;
        }

        return result;
    }
}
