public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        double start = 0;
        double end = Math.max(1, x); /// **** end is not x ****
        
        while(start + 1e-10 < end){
            double mid = start + (end - start)/2;
            if (mid * mid > x){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return start;
    }
}
