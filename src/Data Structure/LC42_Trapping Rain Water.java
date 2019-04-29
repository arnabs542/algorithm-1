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
