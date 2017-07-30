public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end){
        if (start >= end){
            return;
        }
        
        int mid = A[(start + end)/2];
        int left = start;
        int right = end;
        while (left <= right){
            
            while (left <= right && A[left] < mid){
                left ++;
            }
            
            while (left <= right && A[right] > mid){
                right --;
            }
            
            if (left <= right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left ++;
                right --;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
        
    }
}
