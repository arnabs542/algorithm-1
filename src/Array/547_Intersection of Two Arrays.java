/** 
Sol 1.) HashSet O(n)
*/
public class Solution {
   
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i : nums1){
            hs.add(i);
        }
        
        Set<Integer> hsResult = new HashSet<Integer>();

        for(int i : nums2){
            if (hs.contains(i)){
                hsResult.add(i);
            }
        }
        
        int[] result = new int[hsResult.size()];
        int j = 0;
        for (int i : hsResult){
            result[j] = i;
            j ++;
        }
        
        return result;
    }
}

/** Sol 2.) Sort & Merge O(nlogn) + O(nlogn) + O(n)
*/

public class Solution {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // O(nlogn)
        Arrays.sort(nums2); // O(nlogn)
        
        int i = 0; 
        int j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(i < nums1.length && j < nums2.length){
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]){
                i ++;
            }
            
            while (i < nums1.length && j < nums2.length && nums2[j] < nums1[i]){
                j ++;
            }
        
            if (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
                if (result.size() == 0){
                    result.add(nums1[i]);
                } else {
                    if (nums1[i] != result.get(result.size() - 1)){
                        result.add(nums1[i]);
                    }
                }
                
                i ++;
                j ++;
            }
        }
        
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int r: result){
            resultArray[index] = r;
            index ++;
        }
        return resultArray;
        
    }
}

/** Sol 3.) Sort nums1 for binary search O(nlogn) +
 *          Loop through nums2 and add to HashMap O(mlogn)
*/
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
            nums2 == null || nums2.length == 0){
                return new int[0];
            }
        
        Arrays.sort(nums1);
        
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0 ; i < nums2.length; i++){
            if (!hs.contains(nums2[i])){
                hs.add(nums2[i]);
                // binary search
                if (found(nums1, nums2[i])){
                    res.add(nums2[i]);
                }
            }
        }
        
        int[] resultArray = new int[res.size()];
        for (int i = 0; i < res.size(); i ++){
            resultArray[i] = res.get(i);
        }
        return resultArray;
    }
    
    private boolean found(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return true;
            } else if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] == target || nums[end] == target){
            return true;
        }
        
        return false;
    }
}
