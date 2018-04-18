public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (indexA >= 0 &&  indexB >=0){
            if (A[indexA] > B[indexB]){
                A[index] = A[indexA];
                indexA --;
            }else{
                A[index] = B[indexB];
                indexB --;
            }
            index --;
        }
        
        while (indexA >= 0){
            A[index] = A[indexA];
            indexA --;
            index --;
        }
        
        while (indexB >= 0){
            A[index] = B[indexB];
            System.out.println(B[indexB]);
            indexB --;
            index --;
        }
    }
}
