//// 基本款
//// 一個二分找到target, 再去while loop 去找上下界
//// Time: O(logN) + O(N)
public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};

        if (A == null || A.length == 0){
            return result;
        }
        
        int targetIndex = findTarget(A, target);
        int upperBound, lowerBound;
        
        if (targetIndex == -1){
            return result;
        }else{
            upperBound = targetIndex;
            while(upperBound < A.length - 1 && A[upperBound + 1] == target){
                upperBound ++;
            }
            result[1] = upperBound;
            
            lowerBound = targetIndex;
            while(lowerBound > 0 && A[lowerBound - 1] == target){
                lowerBound --;
            }
            result[0] = lowerBound;
        }

        return result;
    }
    
    private int findTarget(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            if (A[mid] == target){
                return mid;
            }else if (A[mid] > target){
                end = mid;
            }else{
                start = mid;
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
        
        if (A[start] > target){
            return start;
        }else{
            return end;
        }
    }
}

// 兩個二分法, 兩種作法time complexity都是一樣的
// 1. 第一個二分法找下界(FirstPositionofTarget), 第二個二分法找比target大的第一個數 (FirstSmallerThanTarget)
// 2. 第一個二分法找下界(FirstPositionofTarget), 第二個二分法找上界(LastPositionofTarget)
// Time: O(2logN)
public class Solution {
   
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};

        if (A == null || A.length == 0){
            return result;
        }
        
        // find lowerbound
        int start = findFirstPositionOfTarget(A, target);
        if (start == -1){
            return result;
        }
        
        // find first greater than target O(logN)
        int end = findFirstGreaterThanTarget(A, target + 1);
        // or we can do 
        // find upperbound => find last position of target O(logN)
        
        result[0] = start;
        result[1] = end;
        return result;
    }
    
    private int findFirstPositionOfTarget(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            if (A[mid] == target){
                end = mid;
            }else if (A[mid] < target){
                start = mid;
            }else{
                end = mid;
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
    
    private int findFirstGreaterThanTarget(int[] A, int target){
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
        
        if (A[end] < target){
            return end;
        }
        
        return start;
    }
    
    

}
