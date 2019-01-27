// O(n)

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i <= height.length; i ++){
            int curr;
            if (i == height.length){
                curr = -1;
            } else {
                curr = height[i];
            }
            
            while(!s.isEmpty() && curr <= height[s.peek()]){
                int h = height[s.pop()];
                int w = s.isEmpty()? i : i - 1 - s.peek();
                max = Math.max(max, h * w);
            }
            s.push(i);
        }
        
        return max;
    }
}
