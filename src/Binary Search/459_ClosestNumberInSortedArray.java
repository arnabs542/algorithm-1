package binarySearch;

public class closestNumber {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0){
            return -1;
        }

        int bsPickedIndex = binarySearch(A, target);

        if (bsPickedIndex == 0){
            return 0;
        }
        if (bsPickedIndex == -1){
            return A.length - 1;
        }

        if (A[bsPickedIndex] - target > target - A[bsPickedIndex - 1]){
            return bsPickedIndex - 1;
        }

        return bsPickedIndex;
    }

    public int binarySearch(int[] A, int target){
        int start = 0;
        int end = A.length -1;

        while(start + 1 < end){
            int mid = start + (end - start)/2;

            if (A[mid] == target){
                end = mid;
            }else if (A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(A[start] >= target){
            return start;
        }

        if(A[end] >= target){
            return end;
        }

        return -1;
    }
}
