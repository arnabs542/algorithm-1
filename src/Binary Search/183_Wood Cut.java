public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    // k = 7
    // L = [232, 124, 456]
    public int woodCut(int[] L, int k) {
        // 找最大值做end 
        int end = Integer.MIN_VALUE;
        for (int l: L){
            end = Math.max(l, end);
        }
        
        int start = 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (woodCutCount(L, mid) >= k){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (woodCutCount(L, end) >= k){
            return end;
        }
        
        if (woodCutCount(L, start) >= k){
            return start;
        }
        
        return 0;
    }
    
    private int woodCutCount(int[] L, int woodSize){
        int count = 0;
        for (int l: L){
            count = count + l/woodSize;
        }
        
        return count;
    }
}
