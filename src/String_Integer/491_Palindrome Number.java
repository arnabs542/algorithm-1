public class Solution {
    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        if(num < 0) {
            return false;
        }
        
        int num_o = num;
        long reversed = 0;
        while(num != 0){
            long temp = reversed * 10 + num % 10;
            num /= 10;
            reversed = temp;
        }
        
        return reversed == num_o;
    }
}
