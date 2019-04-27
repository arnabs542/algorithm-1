// DFS 

class Solution {
    public List<String> generateParenthesis(int n) {
        char[] p = new char[2 * n];
        for (int i = 0; i < n; i ++){
            p[i] = '(';
        }
        for (int i = n; i < 2 * n; i ++){
            p[i] = ')';
        }
        

        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[2 * n];
        DFS(p, 0, visited, "", result);
        
        return result;
    }
    
    private void DFS(char[] p
                    , int index
                    , boolean[] visited
                    , String s
                    , List<String> result){

        if (p.length == index){
            if (isValid(s)){
                result.add(new String(s));
            }
            return;
        }
        
        for (int i = 0; i < p.length; i ++){
            if (visited[i]){

                continue;
            }
            
            if (i > 0 && p[i] == p[i - 1] && !visited[i - 1]){
                continue;
            }
            

            s = s + p[i];
            visited[i] = true;

            DFS(p, index + 1, visited, s, result);
            
            s = s.substring(0, s.length() - 1);
            visited[i] = false;
        }
    }
    
    private boolean isValid(String s){
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++){
            if (c[i] == '('){
                stack.push(c[i]);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
