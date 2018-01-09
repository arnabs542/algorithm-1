public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        String[] test = s.split(" ");
        String result = "";
        
        for (int i = test.length -1; i >= 0; i --){
            result = result + test[i] + (i == 0? "": " ");
        }
        
        
        return result;
    }
}
