package binarySearch;

/**
 * Created by epingho on 2017/6/19.
 */
public class FindPeakElement {
    public int findPeak(int[] A) {
        if (A == null || A.length == 0){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid + 1] - A[mid] >= 0){
                start = mid;
            }else if(A[mid + 1] - A[mid] < 0){
                end = mid;
            }
        }

        if (A[start] > A[end]){
            return start;
        }else{
            return end;
        }
    }
}
