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
