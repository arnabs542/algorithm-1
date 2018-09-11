public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        return helper(a, b, n);
    }
    
    public int helper(int a, int b, int n){
        if (n == 0){
            return 1 % b;
        }
        
        if (n == 1){
            return a % b;
        }
        
        long y = helper(a, b, n/2);
        y = (y * y) % b;
        if (n % 2 == 1){
            y = (y * a) % b;
        }
        return (int) y;
    } 
}
