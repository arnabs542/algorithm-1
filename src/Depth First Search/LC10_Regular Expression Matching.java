// Time: O(SP)
// Space: O(SP)
// S: length of S; P: length of P

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return helper(s, 0, p, 0, memo, visited);
    }
    
    private boolean helper(String s, int sIndex,
                          String p, int pIndex,
                          boolean[][] memo,
                          boolean[][] visited){
        
        if (pIndex == p.length()){
            return sIndex == s.length();
        }
        
        if (sIndex == s.length()){
            return isAllStar(p, pIndex);
        }
        
        if (visited[sIndex][pIndex]){
            return memo[sIndex][pIndex];
        }
        
        char s1 = s.charAt(sIndex);
        char p1 = p.charAt(pIndex);
        char p2 = ' ';
        boolean match;
        if (pIndex + 1 < p.length()){
            p2 = p.charAt(pIndex + 1);
        }
        
        if (p2 == '*'){
            match = helper(s, sIndex, p, pIndex + 2, memo, visited)   // match 0 preceding element
                || canMath(s1, p1) && helper(s, sIndex + 1, p, pIndex, memo, visited);  // match preceding element
        } else {
            match = canMath(s1, p1) && helper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        
        return match;
    }
    
    
    private boolean canMath(char s1, char p1){
        return s1 == p1 || p1 == '.';
    }
    
    private boolean isAllStar(String p, int pIndex){
        // ***** 一次要跳兩個
        for (int i = pIndex; i < p.length(); i += 2){
            // ***** '*'會發生在i + 1
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*'){
                return false;
            }
        }
        
        return true;
    }
}
