class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null){
            return null;
        }
        
        int[] result = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int index = 0;
        
        while (i < A.length && j < B.length){
            if (A[i] < B[j]){
                result[index] = A[i];
                i ++;
            }else{
                result[index] = B[j];
                j ++;
            }
            index ++;
        }
        
        while (i < A.length){
            result[index] = A[i];
            i ++;
            index ++;
        }
        
        while (j < B.length){
            result[index] = B[j];
            j ++;
            index ++;
        }
        
        return result;
    }
}
