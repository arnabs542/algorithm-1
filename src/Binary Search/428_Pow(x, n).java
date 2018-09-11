public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (n >= 0){
            return helper(x, n);
        }else{
            return 1 / helper(x, n);
        }
    }
    
    private double helper(double x, int n){
        if(n == 0){
            return 1;
        }
        
        double y = helper(x, n/2);
        y = y * y;
        if (n % 2 == 1 || n % 2 == -1){
            y = y * x;
        }
        
        return y;
    }
}
