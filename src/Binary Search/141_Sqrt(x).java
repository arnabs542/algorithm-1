public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    // 找x的平方根
    public int sqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            if (mid * mid >= x){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        System.out.println(start);
        System.out.println(end); 

        if (end * end <= x){
            return (int)end;
        }
        
        return (int)start;
    }
}
