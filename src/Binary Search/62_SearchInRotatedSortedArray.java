package binarySearch;

/**
 * Created by epingho on 2017/6/19.
 */
public class s {

    public int search(int[] A, int target) {
        if (A.length == 0 || A == null){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target){
                return mid;
            }else if (A[mid] > target ){
                if (A[mid] > A[end] && target <= A[end])
                {
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if (A[mid] < A[end] && target > A[end])
                {
                    end = mid;
                }else{
                    start = mid;
                }
            }
        }

        if (A[start] == target){
            return start;
        }

        if (A[end] == target){
            return end;
        }

        return -1;
    }
}
