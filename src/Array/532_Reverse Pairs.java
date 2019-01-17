public class Solution {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    // 2, 4, 1, 3, 5
    // 2, 4, 1    3, 5
    // 2, 4, 1
    // 2, 4 
    // 2, 4  1 ----------- + 2
    // 1, 2, 4    3, 5
    // 1, 2, 3, 4, 5
    
    public long reversePairs(int[] A) {
        return mergeSort(0, A.length -1, A);
    }
    
    private int mergeSort(int start, int end, int[] A){
        if (start >= end){
            return 0;
        }
        
        int count = 0;
        int mid = start + (end - start) / 2;
        count = count + mergeSort(start, mid, A);
        count = count + mergeSort(mid + 1, end, A);
        count = count + merge(start, end, mid, A);
        return count;
    }
    
    private int merge(int start, int end, int mid, int[] A){
        int[] temp = new int[A.length];
        int count = 0;
        int index = start;
        int leftStart = start;
        int rightStart = mid + 1;
        while(leftStart <= mid && rightStart <= end){
            if (A[leftStart] <= A[rightStart]){
                temp[index] = A[leftStart];
                leftStart ++;
                index ++;
            } else {
                temp[index] = A[rightStart];
                count = count + mid - leftStart + 1;
                rightStart ++;
                index ++;
            }
        }
        
        while(leftStart <= mid){
            temp[index] = A[leftStart];
            index ++;
            leftStart ++;
        }
        
        while(rightStart <= end){
            temp[index] = A[rightStart];
            index ++;
            rightStart ++;
        }
        
        for (int i = start; i <= end; i++){
            A[i] = temp[i];
        }
        
        return count;
        
    }
}
