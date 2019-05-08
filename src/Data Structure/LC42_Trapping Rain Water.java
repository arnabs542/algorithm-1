// Time: O(N)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int l_height = height[l];
        int r_height = height[r];
        int water = 0;
        while (l < r){
            if (height[l] < height[r]){
                l ++;
                if (height[l] < l_height){ // water
                    water = water + l_height - height[l];
                } else {
                    l_height = height[l];
                }
            } else {
                r --;
                if (height[r] < r_height){ // water
                    water = water + r_height - height[r];
                } else {
                    r_height = height[r];
                }
            }
        }
        
        return water;
            
    }
}

// Time: O(N)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int totalWater = 0;
        for (int i = 0; i < height.length; i ++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int prevH = stack.pop();
                if (!stack.isEmpty()){
                    int minH = Math.min(height[i], height[stack.peek()]);
                    int h = Math.max(minH - height[prevH], 0);
                    int w = i - stack.peek() - 1;
                    totalWater = totalWater + h * w;
                }
            }
            stack.push(i);
        }
        return totalWater;
    }
}
