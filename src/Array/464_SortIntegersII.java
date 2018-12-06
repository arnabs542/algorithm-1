///// Solution 1: Quick sort
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
            
            // left <= right; "=" 為了錯開指針
            // A[left] < mid; no "=" 為了讓左右可以分配平均一點; "=" 的情況可以交換; 左右指針繼續前進; 
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


///// Solution 2: Merge sort

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(0, A.length -1, temp, A);
    }
    
    private void mergeSort(int start, int end, int[] temp, int[] A){
        if (start >= end){
            return;
        }
        
        int mid = start + (end - start)/2;
        mergeSort(start, mid, temp, A);
        mergeSort(mid + 1, end, temp, A);
        merge(start, mid, end, temp, A);
    }
    
    private void merge(int start, int mid, int end, int[] temp, int[] A){
        int leftStart = start;
        int rightStart = mid + 1;
        int index = start;
        
        while(leftStart <= mid && rightStart <= end){
            if (A[leftStart] <= A[rightStart]){
                temp[index] = A[leftStart];
                leftStart ++;
            } else {
                temp[index] = A[rightStart];
                rightStart ++;
            }
            index ++;
        }
        
        while (leftStart <= mid){
            temp[index] = A[leftStart];
            index ++;
            leftStart ++;
        }
        
        while (rightStart <= end){
            temp[index] = A[rightStart];
            index ++;
            rightStart ++;
        }
        
        for (int i = start; i <= end; i++){
            A[i] = temp[i];
        }
    }
}
