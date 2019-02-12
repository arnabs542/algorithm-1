// 兩個array 各自去找看看有沒有k/2個數
// O(log(m + n)
public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;
        if (n % 2 == 0){
            return (findKthSmallest(A, 0, B, 0, n/2) + findKthSmallest(A, 0, B, 0, n/2 + 1))/2.0;
        }
        
         return findKthSmallest(A, 0, B, 0, n/2 + 1);

    }
    
    // 找第k個數, k start from 1, 2, 3 ... 
    private double findKthSmallest(int[] A, int AStartIndex, int[] B, int BStartIndex, int k){
        if (AStartIndex > A.length -1){
            return B[BStartIndex + k -1];
        }
        
        if (BStartIndex > B.length -1){
            return A[AStartIndex + k -1];
        }
        
        if (k == 1){
            return Math.min(A[AStartIndex], B[BStartIndex]);
        }
        
        int mid = k / 2; // 兩個array 各自去找看看有沒有k/2個數 
        
        int midA = AStartIndex + mid - 1 < A.length ? A[AStartIndex + mid - 1]: Integer.MAX_VALUE; 
        // mid is 第k/2個數, 換成index => mid - 1
        int midB = BStartIndex + mid - 1 < B.length ? B[BStartIndex + mid - 1]: Integer.MAX_VALUE;
        
        // 比大小, 從小的那個array裡面一次拿掉k/2個數
        if(midA > midB) {
            return findKthSmallest(A, AStartIndex, B, BStartIndex + mid, k - mid); 
        } 
        
        return findKthSmallest(A, AStartIndex + mid, B, BStartIndex, k - mid);
        
    }
}
