public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0){
            return true;
        }
        
        int left = 0;
        int right = s.length() -1;
        
        while (left < right){
            while(left < s.length() && !isLetter(s.charAt(left))){
                left ++;
            }
            
            if (left == s.length()) { // for emtpy string “.,,,”     
                return true; 
            }  
            
            while(right >= 0 && !isLetter(s.charAt(right))){
                right --;
            }
            
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))){
                return false;
            } else{
                left ++;
                right --;    
            }
            
        }
        
        return true;
        
    }
    
    public boolean isLetter(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}


public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        char[] stringArray = s.toLowerCase().toCharArray();
        for (int i = 0, j = stringArray.length - 1; i < j; i ++, j --){
            while(i < stringArray.length && !isValid(stringArray[i])){
                i ++;
            }
            while(j >= 0 && !isValid(stringArray[j])){
                j --;
            }
            
            if (i < stringArray.length && j >= 0 ){
                if (stringArray[i] != stringArray[j]){
                return false;
            }
            }
            
        }
        
        return true;
    }
    
    public boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
