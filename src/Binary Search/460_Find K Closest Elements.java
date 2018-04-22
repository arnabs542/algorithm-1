public class Solution {
    
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];
        if (A == null || A.length == 0){
            return result;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = (start + end)/2;
            if (A[mid] <= target){
                start = mid;
            }else {
                end = mid;
            }
        }
        
        int resultIndex = 0;
        for (int i = 0; i < k; i ++){
            if (isCloserToLeft(A, target, start, end)){
                result[i] = A[start];
                start --;
            } else {
                result[i] = A[end];
                end ++;
            }
        }
        
        return result;
    }
    
    private boolean isCloserToLeft(int[] A, int target, int start, int end){
        if (start < 0){
            return false;
        }
        
        if (end > A.length - 1){
            return true;
        }
        
        // start and end 跟target相差一樣的時候, 先放左邊, 再放右邊
        if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)){
            return true;
        }
        
        return false;
    }
}
