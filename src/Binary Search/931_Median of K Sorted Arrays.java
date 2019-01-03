public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public double findMedian(int[][] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == null || nums[i].length == 0){
                continue;
            }
            c = c + nums[i].length;
            min = Math.min(min, nums[i][0]);
            max = Math.max(max, nums[i][nums[i].length - 1]);
        }
        
        System.out.println(c);
        if (c == 0){
            return 0;
        }
        
        if (c % 2 == 1){
            return findKth(nums, c/2 + 1);
        }
        
        return (findKth(nums, c/2) + findKth(nums, c/2 + 1)) / 2.0;
    }
    
    private int findKth(int[][] nums, int k){
        // 2分答案, 找出一個range 在median的位置
        // 先試試看mid有沒有在哪個array裡
        // 再看看比mid小的個數是不是 = k
        // 如果比k 大, 就mid = mid / 2 再看看有沒有比k 小
        
        // log(range) * log(n) n = count
        int startNum = min;
        int endNum = max;
        int countSmallerThanMid = 0;
        while (startNum + 1 < endNum){
            int mid = (startNum + endNum)/2;
            countSmallerThanMid = findKthMetrix(nums, mid);
            
            if (countSmallerThanMid <= k){
                startNum = mid;
            } else {
                endNum = mid;
            }
        }
        
        if (findKthMetrix(nums, startNum) <= k){
            return startNum;
        }
        
        return endNum;
    }
    
    private int findKthMetrix(int[][] nums, int target){
        int countSmallerThanTarget = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == null || nums[i].length == 0){
                continue;
            }
            countSmallerThanTarget = countSmallerThanTarget + findKthArray(nums[i], target);
        }
        return countSmallerThanTarget;
    }
    
    private int findKthArray(int[] array, int target){
        //最大< target, return array 長度
        if (array[array.length - 1] <= target){
            return array.length;
        }
        
        //最小> target => 表示整個array沒有比target小的
        if (array[0] > target){
            return 0;
        }
        
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end){
            int mid = array[start + (end - start)/2];
            if (mid <= target){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (array[start] <= target){
            return start + 1;
        }
        
        return end + 1;
    }
}



