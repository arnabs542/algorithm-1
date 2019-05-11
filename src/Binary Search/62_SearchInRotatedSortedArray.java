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

// Follow up: if there are duplicate in the array
// 2, 4, 5, 6, 0, 1, 2
// 这个问题在面试中不会让实现完整程序
// 只需要举出能够最坏情况的数据是 [1,1,1,1...0, 1] 里有一个0即可。
// 在这种情况下是无法使用二分法的，复杂度是O(n)
// 因此写个for循环最坏也是O(n)，那就写个for循环就好了
//  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
//  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
