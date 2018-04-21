public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];

        if (A == null || A.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        // find first smaller than target
        int start = firstSmallerThanTarget(A, target);
        if (start == A.length - 1 || start == 0){
            result[0] = start;
        }else {
            result[0] = start + 1;
        }

        // find first greater than target
        int end = firstGreaterThanTarget(A, target);
        if (end == A.length - 1 || end == 0){
            result[1] = end;
        }else {
            result[1] = end - 1;
        }

        return result;
    }
    
    private int firstSmallerThanTarget(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            if (A[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        System.out.println(start);
        System.out.println(end);
        if (A[end] < target){
            return end;
        }else{
            return start;
        }
    }
    
    private int firstGreaterThanTarget(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            if (A[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        System.out.println(start);
        System.out.println(end);
        if (A[start] > target){
            return start;
        }else{
            return end;
        }
    }
    
    

}
