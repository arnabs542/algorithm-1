public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        //x^n
        if (n == 0) {return 1;}
        if(n % 2 == 0){
            double temp = myPow(x, n/2);
            return temp * temp;
        }else{
            double temp = myPow(x, n/2);
            return temp * x;
        }
    }
}


public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // x^n
        if (n == 0){ 
            return 1; 
        } 
        
        int org_n = n;
        double answer = 1;
        double base = x;
        while( n != 0){
            if ( n % 2 == 1 || n % 2 == -1){
                answer = answer * base;
            } 
            base = base * base;
            n = n/2;
        }
        
        if (org_n > 0){
            return answer;
        }
        
        if (org_n < 0){
            return (1/answer);
        }
        
        return 0;
    }
}


