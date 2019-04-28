// O(n)
// 比較高的一邊不動, 比較小的一邊移過去 
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        
        int l = 0;
        int r = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l < r){
            max = Math.max(max, Math.abs(l - r) * Math.min(height[l], height[r]));
            if (height[l] < height[r]){
                l ++;
            } else {
                r --;
            }
        }
        
        return max;
    }
}
