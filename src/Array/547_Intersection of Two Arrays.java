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
